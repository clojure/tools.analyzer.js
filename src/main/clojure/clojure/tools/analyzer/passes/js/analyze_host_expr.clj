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

(defmethod analyze-host-expr :host-interop
  [{:keys [m-or-f target] :as ast}]
  (merge (dissoc ast m-or-f)
         {:op       :host-call
          :method   m-or-f
          :args     []
          :children [:target :args]}))
