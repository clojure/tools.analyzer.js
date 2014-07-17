;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.js
  "Analyzer for clojure code, extends tools.analyzer with JS specific passes/forms"
  (:refer-clojure :exclude [macroexpand-1 var? *ns* ns-resolve])
  (:require [clojure.tools.analyzer
             :as ana
             :refer [analyze analyze-in-env]
             :rename {analyze -analyze}]
            [clojure.tools.analyzer
             [utils :refer [resolve-var resolve-ns ctx -source-info dissoc-env]]
             [ast :refer [prewalk postwalk]]
             [env :as env :refer [*env*]]]
            [clojure.tools.analyzer.passes
             [source-info :refer [source-info]]
             [cleanup :refer [cleanup]]
             [elide-meta :refer [elide-meta elides]]
             [warn-earmuff :refer [warn-earmuff]]
             [add-binding-atom :refer [add-binding-atom]]
             [uniquify :refer [uniquify-locals]]
             [constant-lifter :refer [constant-lift]]]
            [clojure.tools.analyzer.passes.js
             [annotate-tag :refer [annotate-tag]]
             [infer-tag :refer [infer-tag]]
             [analyze-host-expr :refer [analyze-host-expr]]]
            [clojure.tools.analyzer.js.utils
             :refer [desugar-ns-specs validate-ns-specs ns-resource source-path res-path]]
            [cljs
             [tagged-literals :as tags]
             [js-deps :as deps]]
            [clojure.java.io :as io]
            [clojure.tools.reader :as reader]
            [clojure.tools.reader.reader-types :as readers])
  (:import cljs.tagged_literals.JSValue)
  (:alias c.c clojure.core))

(def specials
  "Set of the special forms for clojurescript"
  (into ana/specials '#{ns deftype* defrecord* js* case*}))

(defmulti parse
  "Extension to tools.analyzer/-parse for CLJS special forms"
  (fn [[op & rest] env] op))

(defmethod parse :default
  [form env]
  (ana/-parse form env))

(def ^:dynamic *ns* 'cljs.user)

;; TODO: seed cljs.core/cljs.user
(defn global-env []
  (atom {:namespaces          '{}
         :js-dependency-index (deps/js-dependency-index {})}))

(defn empty-env
  "Returns an empty env map"
  []
  {:context    :ctx/statement
   :locals     {}
   :ns         *ns*})

(defn fix-ns [ns]
  (if (= ns "clojure.core")
    "cljs.core"
    ns))

(defn ns-resolve [ns sym]
  (let [ns (if (string? ns)
             (symbol ns)
             ns)
        sym (if (string? sym)
              (symbol sym)
              sym)]
    (and (find-ns ns)
         (c.c/ns-resolve ns sym))))

(defn maybe-macro [sym {:keys [ns]}]
  (let [var (if-let [sym-ns (fix-ns (namespace sym))]
              (if-let [full-ns (get-in (env/deref-env)
                                       [:namespaces ns :macro-aliases (symbol sym-ns)])]
                (ns-resolve full-ns (name sym))
                (ns-resolve sym-ns (name sym)))
              (get-in (env/deref-env) [:namespaces ns :macro-mappings sym]))]
    (when (:macro (meta var))
      var)))

(defn desugar-host-expr [form env]
  (-> (cond
      (symbol? form)
      (let [ns (namespace form)]
        (cond
         (= "js" ns)
         (list 'js* (name form))

         ;; (and ns (not (resolve-ns (symbol ns) env)))
         ;; (list '. (symbol ns) (symbol (str "-" (symbol (name form)))))

         :else form))

      (and (seq? form)
           (symbol? (first form)))
      (let [[op & expr] form
            opname (name op)
            opns   (namespace op)
            op-s   (str op)]
        (cond

         (= (first opname) \.)
         (let [[target & args] expr
               args (list* (symbol (subs opname 1)) args)]
           (list '. target (if (= 1 (count args))
                             (first args) args)))

         (= (last opname) \.)
         (list* 'new (symbol (subs op-s 0 (dec (count op-s)))) expr)

         (= "js" opns) ;; (js/foo ..) -> ((js* "foo") ..)
         (list* (list 'js* opname) expr)

         ;; (and opns (not (resolve-ns (symbol opns) env)))
         ;; (let [target (symbol opns)
         ;;       op (symbol opname)]
         ;;   (list '. target (if (zero? (count expr))
         ;;                     op
         ;;                     (list* op expr))))

         :else form))
      :else form)
    (with-meta (meta form))))

(defn macroexpand-1 [form env]
  (env/ensure (global-env)
    (if (seq? form)
      (let [op (first form)]
        (if (or (not (symbol? op))
                (specials op))
          form
          (let [clj-macro (maybe-macro op env)]
            (if (and clj-macro
                     ;; (not (resolve-var op env))
                     (not (-> env :locals (get op))))
              (with-bindings (merge {#'c.c/*ns* (create-ns *ns*)}
                                    (when-not (thread-bound? #'*ns*)
                                      {#'*ns* *ns*}))
                (let [ret (apply clj-macro form env (rest form))] ; (m &form &env & args)
                  (if (and (seq? ret)
                           (= 'js* (first ret)))
                    (vary-meta ret merge
                               (when (-> clj-macro meta :cljs.core/numeric)
                                 {:tag 'number}))
                    ret)))
              (desugar-host-expr form env)))))
      (desugar-host-expr form env))))

(defn create-var
  [sym {:keys [ns]}]
  (with-meta {:op   :var
              :name sym
              :ns   ns}
    (meta sym)))

(defn var? [x]
  (= :var (:op x)))

;; can it be :literal ?
(defn analyze-js-value
  [form env]
  (let [val (.val ^JSValue form)
        items-env (ctx env :expr)]
    (if (map? val)
      ;; keys should always be symbols/kewords, do we really need to analyze them?
      {:op       :js-object
       :env      env
       :keys     (mapv (analyze-in-env items-env) (keys val))
       :vals     (mapv (analyze-in-env items-env) (vals val))
       :form     form
       :children [:keys :vals]}
      {:op       :js-array
       :env      env
       :items    (mapv (analyze-in-env items-env) val)
       :form     form
       :children [:items]})))

(defn analyze-form
  [form env]
  (if (instance? JSValue form)
    (analyze-js-value form env)
    (ana/-analyze-form form env)))

(defn parse-type
  [op [_ name fields pmasks body :as form] {:keys [ns] :as env}]
  (let [fields-expr (mapv (fn [name]
                            {:env     env
                             :form    name
                             :name    name
                             :mutable (:mutable (meta name))
                             :local   :field
                             :op      :binding})
                          fields)
        protocols (-> name meta :protocols)

        _ (swap! *env* assoc-in [:namespaces ns :mappings name]
                 {:op        :type
                  :name      name
                  :ns        ns
                  :fields    fields
                  :protocols protocols})

        body-expr (-analyze body (assoc env
                                   :locals (zipmap fields (map dissoc-env fields-expr))))]

    {:op        op
     :env       env
     :form      form
     :name      name
     :fields    fields-expr
     :body      body-expr
     :pmasks    pmasks
     :protocols protocols
     :children  [:fields :body]}))

(defmethod parse 'deftype*
  [form env]
  (parse-type :deftype form env))

(defmethod parse 'defrecord*
  [form env]
  (parse-type :defrecord form env))

;; no ~{foo} support since cljs itself doesn't use it anywhere
(defmethod parse 'js*
  [[_ jsform & args :as form] env]
  (when-not (string? jsform)
    (throw (ex-info "Invalid js* form"
                    (merge {:form form}
                           (-source-info form env)))))
  (let [segs  (loop [segs [] ^String s jsform]
                (let [idx (.indexOf s "~{")]
                  (if (= -1 idx)
                    (conj segs s)
                    (recur (conj segs (subs s 0 idx))
                           (subs s (inc (.indexOf s "}" idx)))))))
        exprs (mapv (analyze-in-env (ctx env :ctx/expr)) args)]
    (merge
     {:op       :js
      :env      env
      :form     form
      :segs     segs}
     (when args
       {:args     exprs
        :children [:args]}))))

(defmethod parse 'case*
  [[_ test tests thens default :as form] env]
  (assert (symbol? test) "case* must switch on symbol")
  (assert (every? vector? tests) "case* tests must be grouped in vectors")
  (let [expr-env (ctx env :expr)
        test-expr (-analyze test expr-env)
        nodes (mapv (fn [tests then]
                      {:op       :case-node
                       :tests    (mapv (fn [test]
                                         {:op       :case-test
                                          :test     (-analyze test expr-env)
                                          :children [:test]})
                                       tests)
                       :then     {:op   :case-then
                                  :then (-analyze then env)
                                  :children [:then]}
                       :children [:tests :then]})
                    tests thens)
        default-expr (-analyze default env)]
    (assert (every? (fn [t] (and (= :const (-> t :test :op))
                           ((some-fn number? string?) (:form t))))
               (mapcat :tests nodes))
            "case* tests must be numbers or strings")
    {:op       :case
     :form     form
     :env      env
     :test     (assoc test-expr :case-test true)
     :nodes    nodes
     :default  default-expr
     :children [:test :nodes :default]}))

(def ^:private ^:dynamic *deps-map* {:path [] :deps #{}})
(declare analyze-ns)

(defn ensure-loaded [ns {:keys [refer]}]
  (assert (not (contains? (:deps *deps-map*) ns))
          (str "Circular dependency detected :" (conj (:path *deps-map*) ns)))
  (binding [*deps-map* (-> *deps-map*
                         (update-in [:path] conj ns)
                         (update-in [:deps] conj ns))]
    (let [namespaces (-> (env/deref-env) :namespaces)]
      (or (and (get namespaces ns)
               (not (get-in namespaces [ns :js-namespace])))
          (and (get-in (env/deref-env) [:js-dependency-index (name ns)])
               (swap! env/*env* update-in [:namespaces ns] merge
                      {:ns           ns
                       :js-namespace true})
               (swap! env/*env* update-in [:namespaces ns :mappings] merge
                      (reduce (fn [m k] (assoc m k {:op          :var
                                                   :name        k
                                                   :namespace   ns
                                                   :assignable? true}))
                              {} refer)))
          (analyze-ns ns)))))

(defn core-macros []
  (reduce-kv (fn [m k v]
               (if (:macro (meta v))
                 (assoc m k v)
                 m))
             {} (ns-interns 'cljs.core)))

(defn populate-env
  [{:keys [import require require-macros refer-clojure]} ns-name env]
  (let [imports (reduce-kv (fn [m prefix suffixes]
                             (merge m (into {} (mapv (fn [s] [s (symbol (str prefix "." s))]) suffixes)))) {} import)
        require-aliases (reduce (fn [m [ns {:keys [as]}]]
                                  (if as
                                    (assoc m as ns)
                                    m)) {} require)
        require-mappings (reduce (fn [m [ns {:keys [refer] :as spec}]]
                                   (ensure-loaded ns spec)
                                   (reduce #(assoc %1 %2 (get-in (env/deref-env)
                                                                 [:namespaces ns :mappings %2])) m refer))
                                 {} require)
        core-mappings (apply dissoc (get-in (env/deref-env) [:namespaces 'cljs.core :mappings]) (:exclude refer-clojure))
        macro-aliases (reduce (fn [m [ns {:keys [as]}]]
                                (if as
                                  (assoc m as ns)
                                  m)) {} require-macros)
        core-macro-mappings (apply dissoc (core-macros) (:exclude refer-clojure))
        macro-mappings (reduce (fn [m [ns {:keys [refer]}]]
                                 (c.c/require ns)
                                 (reduce #(assoc %1 %2 (ns-resolve ns (name %2))) m refer))
                               {} require-macros)]

    (swap! *env* assoc-in [:namespaces ns-name]
           {:ns             ns-name
            :mappings       (merge core-mappings require-mappings imports)
            :aliases        require-aliases
            :macro-mappings (merge core-macro-mappings macro-mappings)
            :macro-aliases  macro-aliases})))

;;TODO: check for circular deps, handle js deps
(defmethod parse 'ns
  [[_ name & args :as form] env]
  (when-not (symbol? name)
    (throw (ex-info (str "Namespaces must be named by a symbol, had: "
                         (.getName ^Class (class name)))
                    (merge {:form form}
                           (-source-info form env)))))
  (let [[docstring & args] (if (string? (first args))
                             args
                             (cons nil args))
        [metadata & args]  (if (map? (first args))
                             args
                             (cons {} args))

        ns-opts (doto (desugar-ns-specs args form env)
                  (validate-ns-specs form env)
                  (populate-env name env))]
    (set! *ns* name)
    (merge
     {:op      :ns
      :env     env
      :form    form
      :name    name
      :depends (set (keys (:require ns-opts)))}
     (when docstring
       {:doc docstring})
     (when metadata
       {:meta metadata}))))

(defn ^:dynamic run-passes [ast]
  (binding [elides (update-in elides [:all] into
                              #{:line :column :end-line :end-column :file :source})]
    (-> ast

      uniquify-locals
      add-binding-atom

      (prewalk (fn [ast]
                 (-> ast
                   warn-earmuff
                   source-info
                   elide-meta)))

      (postwalk (fn [ast]
                  (-> ast
                    annotate-tag
                    analyze-host-expr
                    infer-tag
                    constant-lift))))))

(defn analyze
  ([form] (analyze form (empty-env) {}))
  ([form env] (analyze form env {}))
  ([form env opts]
     (with-bindings (merge {#'ana/macroexpand-1 macroexpand-1
                            #'ana/create-var    create-var
                            #'ana/parse         parse
                            #'ana/var?          var?
                            #'ana/analyze-form  analyze-form}
                           (when-not (thread-bound? #'*ns*)
                             {#'*ns* *ns*})
                           (:bindings opts))
       (env/ensure (global-env)
         (run-passes (-analyze form env))))))

(defn analyze'
  "Like `analyze` but runs cleanup on the AST"
  ([form] (analyze' form (empty-env)))
  ([form env] (analyze' form env {}))
  ([form env opts]
     (prewalk (analyze form env opts) cleanup)))

(defn analyze-ns [ns]
  (env/ensure (global-env)
    (let [res (ns-resource ns)]
      (assert res (str "Can't find " ns " in classpath"))
      (let [filename (source-path res)
            path (res-path res)]
        (when-not (get-in *env* [::analyzed-cljs path])
          (binding [*ns* *ns*]
            (with-open [rdr (io/reader res)]
              (let [pbr (readers/indexing-push-back-reader
                         (java.io.PushbackReader. rdr) 1 filename)
                    eof (Object.)
                    env (empty-env)]
                (loop []
                  (let [form (binding [c.c/*ns* (create-ns *ns*)
                                       reader/*data-readers* tags/*cljs-data-readers*
                                       reader/*alias-map* (apply merge {}
                                                                 (-> (env/deref-env) :namespaces (get *ns*)
                                                                    (select-keys #{:aliases :macro-aliases})
                                                                    vals))]
                               (reader/read pbr nil eof))]
                    (when-not (identical? form eof)
                      (swap! *env* update-in [::analyzed-cljs path]
                             (fnil conj [])
                             (analyze form (assoc env :ns *ns*)))
                      (recur))))))))
        (get-in @*env* [::analyzed-cljs path])))))

(require 'cljs.core)
