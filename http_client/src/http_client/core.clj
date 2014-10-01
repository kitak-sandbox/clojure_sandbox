(ns http-client.core)
(ns http-client.core
  (:require [clj-http.client :as client]))

(defn -main [& args]
  (client/post "http://irc.example.jp:4979/notice" {:form-params {:channel "#test" :message "test"}}))
