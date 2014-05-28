;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.js.utils
  (:require [clojure.string :as s]
            [clojure.tools.analyzer.utils :refer [-source-info]]))

(defn desugar-macros [{:keys [require] :as ns-opts}]
  (let [sugar-keys #{:include-macros :refer-macros}]
    (reduce (fn [ns-opts [ns & opts :as spec]]
              (if (some sugar-keys spec)
                (let [{:keys [refer-macros] :as opts} (apply hash-map opts)]
                  (-> ns-opts
                    (update-in [:require] conj (into [ns] (apply dissoc opts sugar-keys)))
                    (update-in [:require-macros] (fnil conj [])
                               (into [ns] (when refer-macros [:refer refer-macros])))))
                (update-in ns-opts [:require] conj spec)))
            (assoc ns-opts :require []) require)))

;;TODO: assumes the libspecs are valid, crashes otherwise
;; needs to validate them
(defn desugar-use [{:keys [use use-macros] :as ns-opts}]
  (let [ns-opts (reduce (fn [ns-opts [lib only syms]]
                          (update-in ns-opts [:require] (fnil conj []) [lib :refer syms]))
                        ns-opts use)]
    (reduce (fn [ns-opts [lib only syms]]
              (update-in ns-opts [:require-macros] (fnil conj []) [lib :refer syms]))
            ns-opts use)))

(defn desugar-import [{:keys [import] :as ns-opts}]
  (reduce (fn [ns-opts import]
            (if (symbol? import)
              (let [s (s/split (name import) ".")]
                (update-in ns-opts [:import] (fnil conj []) [(symbol (s/join "." (butlast s)))
                                                           (symbol (last s))]))
              (update-in ns-opts [:import] (fnil conj []) import)))
          ns-opts import))

;; desugars :include-macros/:refer-mcros into :require/:require-macros
;; and :use/:use-macros into :require/:require-macros
(defn desugar-ns-specs [ns-opts]
  (let [vectorize-dep (fn [opts]
                        (update-in opts [:require]
                                   #(reduce (fn [r s]
                                              (if (sequential? s)
                                                (conj r s)
                                                (conj r [s]))) [] %)))]
   (-> ns-opts desugar-macros desugar-use desugar-import vectorize-dep)))

;; TODO: validate
(defn validate-ns-specs [ns-opts form env]
  (when-let [invalid (seq (dissoc ns-opts :require :require-macros :import :refer-clojure))]
    (throw (ex-info (str "Unsupported ns spec(s): " invalid)
                    (merge {:form form}
                           (-source-info form env))))))

(defn populate-env
  [{:keys [import require require-macros refer-clojure]} name {:keys [namespaces]}]
  (let [imports (reduce (fn [m [prefix suffix]]
                          (assoc m suffix (symbol (str prefix "." suffix)))) {} import)
        requires (reduce (fn [m [ns & opts]]
                           (assoc m ns (apply hash-map opts))) {} require)
        require-aliases (reduce (fn [m [ns {:keys [as]}]]
                                  (if as
                                    (assoc m as ns)
                                    m)) {} requires)
        ;; TODO: assumes all required namespaces are loaded, must handle loading
        require-mappings (reduce (fn [m [ns {:keys [refer]}]]
                                   (reduce #(assoc % (get-in @namespaces [ns :mappings %])) m refer))
                                 {} requires)
        core-mappings (apply dissoc (get-in @namespaces ['cljs.core :mappings]) (:exclude refer-clojure))]

    (swap! namespaces assoc-in [name]
           {:ns       name
            :mappings (merge core-mappings require-mappings)
            :aliases  (merge imports require-aliases)})))
