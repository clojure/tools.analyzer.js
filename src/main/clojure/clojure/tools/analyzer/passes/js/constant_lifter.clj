(ns clojure.tools.analyzer.passes.js.constant-lifter
  (:require [clojure.tools.analyzer.passes.constant-lifter :as orig]
            [clojure.tools.analyzer.utils :refer [const-val]]))

(defn literal [ast]
  (assoc ast :literal? true))

(defn constant-lift*
  [{:keys [op meta] :as ast}]
  (if (and meta (= :def op) (= :map (:op meta)))
    (assoc-in ast [:meta] (orig/constant-lift
                            (merge (with-meta meta {})
                                   {:keys (mapv literal (:keys meta))
                                    :vals (mapv literal (:vals meta))})))
    (orig/constant-lift ast)))

(defn constant-lift
  [ast]
  (merge (constant-lift* ast)
         (select-keys ast [:tag :return-tag :arglists])))
