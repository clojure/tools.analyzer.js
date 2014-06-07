;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.js.annotate-tag)

(defmulti -annotate-tag :op)

(defmethod -annotate-tag :seq
  [ast]
  (assoc ast :tag 'cljs.core/IList))

(defmethod -annotate-tag :vector
  [ast]
  (assoc ast :tag 'cljs.core/IVector))

(defmethod -annotate-tag :map
  [ast]
  (assoc ast :tag 'cljs.core/IMap))

(defmethod -annotate-tag :set
  [ast]
  (assoc ast :tag 'cljs.core/ISet))

(defmethod -annotate-tag :js-array
  [ast]
  (assoc ast :tag 'array))

(defmethod -annotate-tag :js-object
  [ast]
  (assoc ast :tag 'object))

(defmethod -annotate-tag :fn
  [ast]
  (assoc ast :tag 'function))

(defmethod -annotate-tag :const
  [ast]
  ((get-method -annotate-tag (:type ast)) ast))

(defmethod -annotate-tag :nil
  [ast]
  (assoc ast :tag 'clj-nil))

(defmethod -annotate-tag :number
  [ast]
  (assoc ast :tag 'number))

(defmethod -annotate-tag :string
  [ast]
  (assoc ast :tag 'string))

(defmethod -annotate-tag :bool
  [ast]
  (assoc ast :tag 'boolean))

(defmethod -annotate-tag :symbol
  [ast]
  (assoc ast :tag 'cljs.core/Symbol))

(defmethod -annotate-tag :keyword
  [ast]
  (assoc ast :tag 'cljs.core/Keyword))

(defmethod -annotate-tag :new
  [{:keys [class] :as ast}]
  (assoc ast :tag (case class
                    js/Object   'object
                    js/String   'string
                    js/Array    'array
                    js/Number   'number
                    js/Function 'function
                    js/Boolean  'boolean
                    class)))

(defmethod -annotate-tag :default [ast] ast)

;; TODO: handle :numeric
(defn annotate-tag
  [ast]
  (if-let [tag (or (-> ast :val meta :tag)
                   (-> ast :form meta :tag))]
    (assoc ast :tag tag)
    (-annotate-tag ast)))
