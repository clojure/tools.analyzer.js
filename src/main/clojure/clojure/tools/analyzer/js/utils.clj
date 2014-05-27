;;   Copyright (c) Nicola Mometto, Rich Hickey & contributors.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file epl-v10.html at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns clojure.tools.analyzer.js.utils)

(defn desugar-ns-specs [{:keys [require] :as ns-opts}]
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
