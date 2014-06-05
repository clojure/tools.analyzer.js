;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.js
  "Analyzer for clojure code, extends tools.analyzer with JS specific passes/forms"
  (:refer-clojure :exclude [macroexpand-1 var? *ns*])
  (:require [clojure.tools.analyzer
             :as ana
             :refer [analyze analyze-in-env]
             :rename {analyze -analyze}]
            [clojure.tools.analyzer
             [utils :refer [resolve-var ctx -source-info]]
             [ast :refer [prewalk]]
             [env :as env :refer [*env*]]]
            [clojure.tools.analyzer.passes
             [cleanup :refer [cleanup]]]
            [clojure.tools.analyzer.js.utils
             :refer [desugar-ns-specs validate-ns-specs ns-resource source-path res-path]]
            [clojure.java.io :as io]
            [cljs.tagged-literals :as tags]
            [clojure.tools.reader :as reader]
            [clojure.tools.reader.reader-types :as readers])
  (:import cljs.tagged_literals.JSValue)
  (:alias c.c clojure.core))

(def specials
  "Set of the special forms for clojurescript"
  (into ana/specials '#{ns deftype* defrecord* js*}))

(defmulti parse
  "Extension to tools.analyzer/-parse for CLJS special forms"
  (fn [[op & rest] env] op))

(defmethod parse :default
  [form env]
  (ana/-parse form env))

(def ^:dynamic *ns* 'cljs.user)

(defn global-env []
  (atom '{:namespaces {cljs.user {:mappings       {}
                                  :aliases        {}
                                  :macro-mappings {}
                                  :macro-aliases  {}
                                  :ns             cljs.user}
                       cljs.core {:mappings       {}
                                  :aliases        {}
                                  :macro-mappings {}
                                  :macro-aliases  {}
                                  :ns             cljs.core}}}))

(defn empty-env
  "Returns an empty env map"
  []
  {:context    :statement
   :locals     {}
   :ns         *ns*})

(defn desugar-host-expr [[op & expr :as form]]
  (if (symbol? op)
    (let [opname (name op)]
      (cond

       (= (first opname) \.)
       (let [[target & args] expr
             args (list* (symbol (subs opname 1)) args)]
         (with-meta (list '. target (if (= 1 (count args))
                                      (first args) args))
           (meta form)))

       (= (last opname) \.)
       (with-meta (list* 'new (symbol (subs opname 0 (dec (count opname)))) expr)
         (meta form))

       :else form))
    form))

(defn maybe-macro [sym {:keys [ns]}]
  (let [var (if-let [sym-ns (namespace sym)]
              (if-let [full-ns (get-in (env/deref-env)
                                       [:namespaces ns :macro-aliases (symbol sym-ns)])]
                (ns-resolve full-ns (symbol (name sym)))
                (ns-resolve (symbol sym-ns) (symbol (name sym))))
              (get-in (env/deref-env) [:namespaces ns :mcacro-mappings sym]))]
    (when (:macro (meta var))
      var)))

(defn macroexpand-1 [form env]
  (env/ensure (global-env)
    (if (seq? form)
      (let [op (first form)]
        (if (specials op)
          form
          (let [clj-macro (maybe-macro op env)]
            (if (and clj-macro
                     (not (resolve-var op env))
                     (not (-> env :locals (get op))))
              (apply clj-macro form env (rest form)) ; (m &form &env & args)
              (desugar-host-expr form)))))
      form)))

(defn create-var
  [sym {:keys [ns]}]
  {:op   :var
   :name sym
   :ns   ns})

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
  [op [_ name fields pmasks :as form] {:keys [ns] :as env}]
  (let [fields-expr (mapv (fn [name]
                            {:env     env
                             :form    name
                             :name    name
                             :mutable (:mutable (meta name))
                             :local   :field
                             :op      :binding})
                          fields)
        protocols (-> name meta :protocols)]

    (swap! *env* assoc-in [:namespaces ns :mappings name]
           {:op        :type
            :name      name
            :ns        ns
            :fields    fields
            :protocols protocols})

    {:op        op
     :env       env
     :form      form
     :name      name
     :fields    fields-expr
     :pmasks    pmasks
     :protocols protocols
     :children  [:fields]}))

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
        exprs (mapv (analyze-in-env (ctx env :expr)) args)]
    (merge
     {:op       :js
      :env      env
      :form     form
      :segs     segs}
     (when args
       {:args     exprs
        :children [:args]}))))

(declare analyze-ns)
(defn ensure-loaded [ns env]
  (or (-> (env/deref-env) :namespaces ns)
      (analyze-ns ns env)))

(defn populate-env
  [{:keys [import require require-macros refer-clojure]} ns-name env]
  (let [imports (reduce-kv (fn [m prefix suffixes]
                             (merge m (into {} (mapv (fn [s] [s (symbol (str prefix "." s))]) suffixes)))) {} import)
        require-aliases (reduce (fn [m [ns {:keys [as]}]]
                                  (if as
                                    (assoc m as ns)
                                    m)) {} require)
        require-mappings (reduce (fn [m [ns {:keys [refer]}]]
                                   (ensure-loaded ns env)
                                   (reduce #(assoc %1 %2 (get-in (env/deref-env)
                                                                 [:namespaces ns :mappings %2])) m refer))
                                 {} require)
        core-mappings (apply dissoc (get-in (env/deref-env) [:namespaces 'cljs.core :mappings]) (:exclude refer-clojure))
        macro-aliases (reduce (fn [m [ns {:keys [as]}]]
                                (if as
                                  (assoc m as ns)
                                  m)) {} require-macros)
        macro-mappings (reduce (fn [m [ns {:keys [refer]}]]
                                 (clojure.core/require ns)
                                 (reduce #(assoc %1 %2 (ns-resolve ns (symbol (name %2)))) m refer))
                               {} require-macros)]

    (swap! *env* assoc-in [:namespaces ns-name]
           {:ns             ns-name
            :mappings       (merge core-mappings require-mappings)
            :aliases        (merge imports require-aliases)
            :macro-mappings macro-mappings
            :macro-aliases  macro-aliases})))

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

(defn run-passes [ast]
  (-> ast))

;; assumes *ns* is bound
(defn analyze
  ([form] (analyze form (empty-env) {}))
  ([form env] (analyze form env {}))
  ([form env opts]
     (with-bindings (merge {#'ana/macroexpand-1 macroexpand-1
                            #'ana/create-var    create-var
                            #'ana/parse         parse
                            #'ana/var?          var?
                            #'ana/analyze-form  analyze-form}
                           (:bindings opts))
       (env/ensure (global-env)
         (run-passes (-analyze form env))))))

(defn analyze'
  "Like `analyze` but runs cleanup on the AST"
  ([form] (analyze' form (empty-env)))
  ([form env] (analyze' form env {}))
  ([form env opts]
     (prewalk (analyze form env opts) cleanup)))

(defn analyze-ns [ns env]
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
                      (recur))))))))))))
