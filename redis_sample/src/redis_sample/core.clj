(ns redis-sample.core
  (:require [taoensso.carmine :as car :refer (wcar)]))

(def server1-conn {:pool {} :sepc {:host "127.0.0.1" :port 6379}})
(defmacro wcar* [& body] `(car/wcar server1-conn ~@body))

(defn -main [& args]
  (wcar* (car/set "foo" "bar"))
  (println (wcar* (car/get "foo"))))
