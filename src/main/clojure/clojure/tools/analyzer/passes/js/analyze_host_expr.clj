;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.js.analyze-host-expr
  (:require [clojure.tools.analyzer :as ana]
            [clojure.tools.analyzer.utils :refer [resolve-var resolve-ns]]
            [clojure.tools.analyzer.env :as env]))


(defmulti analyze-host-expr :op)
(defmethod analyze-host-expr :default [ast] ast)

(defmethod analyze-host-expr :maybe-class
  [{:keys [class env form] :as ast}]
  (if-let [the-class (resolve-var class env)]
    (merge (ana/-analyze :const the-class env :class)
           {:form form})
    ast))

;;TODO: should theose be handled like :host-field instead?
(defmethod analyze-host-expr :maybe-host-form
  [{:keys [class field env] :as ast}]
  (if-let [ns (resolve-ns class env)]
    (if (get-in (env/deref-env) [:namespaces ns :js-namespace])
      (let [var {:op          :var
                 :name        field
                 :namespace   ns
                 :assignable? true}]
        (swap! env/*env* assoc-in [:namespaces ns :mappings field] var)
        (merge (dissoc ast :class :field) var))
      ast)
    ast))

(defmethod analyze-host-expr :host-interop
  [{:keys [m-or-f target] :as ast}]
  (merge (dissoc ast m-or-f)
         {:op       :host-call
          :method   m-or-f
          :args     []
          :children [:target :args]}))
