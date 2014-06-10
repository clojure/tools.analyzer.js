;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.passes.js.infer-tag)

(defmulti -infer-tag :op)
(defmethod -infer-tag :default [ast] ast)

(defmethod -infer-tag :recur
  [ast]
  (assoc ast :tag 'ignore :ignore-tag true))

(defmethod -infer-tag :throw
  [ast]
  (assoc ast :tag 'ignore :ignore-tag true))

(defmethod -infer-tag :with-meta
  [{:keys [expr] :as ast}]
  (merge ast (select-keys expr [:return-tag :arglists :ignore-tag :tag])))

(defmethod -infer-tag :do
  [{:keys [ret] :as ast}]
  (merge ast (select-keys ret [:return-tag :arglists :ignore-tag :tag])))

(defmethod -infer-tag :let
  [{:keys [body] :as ast}]
  (merge ast (select-keys body [:return-tag :arglists :ignore-tag :tag])))

(defmethod -infer-tag :letfn
  [{:keys [body] :as ast}]
  (merge ast (select-keys body [:return-tag :arglists :ignore-tag :tag])))

(defmethod -infer-tag :loop
  [{:keys [body] :as ast}]
  (merge ast (select-keys body [:return-tag :arglists :ignore-tag :tag])))

(defn =-arglists? [a1 a2]
  (let [tag (fn [x] (-> x meta :tag))]
    (and (= a1 a2)
         (every? true? (mapv (fn [a1 a2]
                       (and (= (tag a1) (tag a2))
                            (= (mapv tag a1)
                               (mapv tag a2))))
                     a1 a2)))))

(defmethod -infer-tag :if
  [{:keys [then else] :as ast}]
  (let [then-tag (:tag then)
        else-tag (:tag else)
        ignore-then? (:ignore-tag then)
        ignore-else? (:ignore-tag else)]
    (cond
     (and then-tag
          (or ignore-else? (= then-tag else-tag)))
     (merge ast
            {:tag then-tag}
            (when-let [return-tag (:return-tag then)]
              (when (or ignore-else?
                        (= return-tag (:return-tag else)))
                {:return-tag return-tag}))
            (when-let [arglists (:arglists then)]
              (when (or ignore-else?
                        (=-arglists? arglists (:arglists else)))
                {:arglists arglists})))

     (and else-tag ignore-then?)
     (merge ast
            {:tag else-tag}
            (when-let [return-tag (:return-tag else)]
              {:return-tag return-tag})
            (when-let [arglists (:arglists else)]
              {:arglists arglists}))

     (and (:ignore-tag then) (:ignore-tag else))
     (assoc ast :tag 'ignore :ignore-tag true)

     :else
     ast)))

(defn infer-tag
  [{:keys [tag] :as tag}]
  (merge (-infer-tag ast)
         (when tag
           {:tag tag})))
