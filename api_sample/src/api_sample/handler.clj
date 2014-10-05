(ns api_sample.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :refer [resource-response response]]
            [ring.middleware.json :as middleware]
            [clj-time.local :as tl]
            [clj-time.format :as tf]))

(defn current_time []
  (tf/unparse (tf/formatter-local "kk:mm:ss") (tl/local-now)))
(println (current_time))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (POST "/time/current" [
        (response {:value (current_time)}))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/site app-routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)))
