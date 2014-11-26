;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.js.annotate-tag)

(defmulti -annotate-tag :op)

(defmethod -annotate-tag :op/vector
  [ast]
  (assoc ast :tag 'cljs.core/IVector))

(defmethod -annotate-tag :op/map
  [ast]
  (assoc ast :tag 'cljs.core/IMap))

(defmethod -annotate-tag :op/set
  [ast]
  (assoc ast :tag 'cljs.core/ISet))

(defmethod -annotate-tag :op/js-array
  [ast]
  (assoc ast :tag 'array))

(defmethod -annotate-tag :op/js-object
  [ast]
  (assoc ast :tag 'object))

(defmethod -annotate-tag :op/js
  [{:keys [form] :as ast}]
  (if (-> form meta :numeric)
    (assoc ast :tag 'number)
    ast))

(defmethod -annotate-tag :op/fn
  [ast]
  (assoc ast :tag 'function))

(defmethod -annotate-tag :op/const
  [ast]
  (let [tag (get '{:vector  cljs.core/IVector
                   :seq     cljs.core/IList
                   :map     cljs.core/IMap
                   :set     cljs.core/ISet
                   :nil       clj-nil
                   :number  number
                   :string  string
                   :bool    boolean
                   :symbol  cljs.core/Symbol
                   :keyword cljs.core/Keyword}
                 (:type ast) 'any)]
    (assoc ast :tag tag)))

(defmethod -annotate-tag :default [ast] ast)

(defn annotate-tag
  "If the AST node type is a constant object or contains :tag metadata,
   attach the appropriate :tag to the node."
  {:pass-info {:walk :any :depends #{}}}
  [ast]
  (if-let [tag (or (-> ast :form meta :tag)
                   (-> ast :val meta :tag))]
    (assoc ast :tag tag)
    (-annotate-tag ast)))
