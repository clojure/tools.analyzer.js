(ns clojure.tools.analyzer.js.core-test
  (:require [clojure.tools.analyzer.js :as js]
            [clojure.tools.analyzer.env :as env]
            [clojure.test :refer :all]))

(def env (js/global-env))

(deftest analyzer-test
  (is (env/with-env env (js/analyze-ns 'cljs.core))))
