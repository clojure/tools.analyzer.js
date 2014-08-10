;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.js.analyze-host-expr
  (:require [clojure.tools.analyzer.env :as env]
            [clojure.tools.analyzer.utils :refer [resolve-ns]]))

(defmulti analyze-host-expr :op)

(defmethod analyze-host-expr :default [ast] ast)

(defmethod analyze-host-expr :host-interop
  [{:keys [m-or-f target] :as ast}]
  (merge (dissoc ast :m-or-f)
         {:op       :host-call
          :method   m-or-f
          :args     []
          :children [:target :args]}))

(defmethod analyze-host-expr :maybe-class
  [{:keys [class] :as ast}]
  (if-let [v (resolve-var form env)]
    (merge (dissoc ast :class)
           {:op  :js-var
            :var v})
    ast))

(defmethod analyze-host-expr :maybe-host-form
  [{:keys [class field env] :as ast}]
  (cond
   (= 'js class)
   (merge (dissoc ast :field :class)
          {:op  :js-var
           :var {:op   :js-var
                 :name field
                 :ns   nil}})
   (get-in (env/deref-env) [:namespaces (resolve-ns class env) :js-namespace])
   (merge (dissoc ast :field :class)
          {:op  :js-var
           :var {:op   :js-var
                 :name field
                 :ns   (resolve-ns class env)}})
   :else
   ast))
