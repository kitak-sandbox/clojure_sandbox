(ns json-sample.core
  (:require [cheshire.core :as cheshire]))

(defn -main [& args]
  (println (cheshire/generate-string {:name "kitak" :age 23})))
