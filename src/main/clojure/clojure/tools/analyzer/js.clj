;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.js
  "Analyzer for clojure code, extends tools.analyzer with JS specific passes/forms"
  (:refer-clojure :exclude [macroexpand-1 var?])
  (:require [clojure.tools.analyzer
             :as ana
             :refer [analyze analyze-in-env ctx]
             :rename {analyze -analyze}]
            [clojure.tools.analyzer.utils :refer [resolve-var]]
            cljs.tagged-literals)
  (:import cljs.tagged_literals.JSValue))

(def specials
  "Set of the special forms for clojurescript"
  (into ana/specials '#{ns deftype* defrecord* js*}))

(defmulti parse
  "Extension to tools.analyzer/-parse for CLJS special forms"
  (fn [[op & rest] env] op))

(defmethod parse :default
  [form env]
  (ana/-parse form env))

(defn empty-env
  "Returns an empty env map"
  []
  {:context    :expr
   :locals     {}
   :ns         'cljs.user
   :namespaces (atom '{cljs.user {:mappings {}
                                  :aliases  {}
                                  :ns       'cljs.user}
                       cljs.core {:mappings {}
                                  :aliases  {}
                                  :ns       'cljs.core}})})

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

(defn macroexpand-1 [form env]
  (if (seq? form)
    (let [op (first form)]
      (if (specials op)
        form
        (let [v (resolve-var op env)
              clj-var (clojure.core/resolve op)]
          (if (and clj-var
                   (not (-> env :locals (get op)))
                   (not v)
                   (:macro (meta clj-var)))
            (apply clj-var form env (rest form)) ; (m &form &env & args)
            (desugar-host-expr form)))))
        form))

(defrecord Var [name namespace])

(defn create-var
  [sym {:keys [ns]}]
  (->Var sym ns))

(defn var? [x]
  (instance? Var x))

(defn analyze-js-value
  [form env]
  (let [val (.val ^JSValue form)
        items-env (ctx env :expr)
        items (if (map? val)
                (zipmap (keys val)
                        (mapv (analyze-in-env items-env) (vals val)))
                (mapv (analyze-in-env items-env) val))]
    {:op       :js-value
     :js-type  (if (map? val) :object :array)
     :env      env
     :items    items
     :form     form
     :children [:items]}))

(defn analyze-form
  [form env]
  (if (instance? JSValue form)
    (analyze-js-value form env)
    (ana/-analyze-form form env)))

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
                    (-analyze form env))))
