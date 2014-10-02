(ns feed_sample.core
  (:require [feedparser-clj.core :as feedparser]))

(defn -main [& args]
  (def feed (feedparser/parse-feed "http://qiita.com/tags/clojure/feed"))
  (println (count (:entries feed)))
  (println (clojure.string/join "\n" (map :title (take 5 (:entries feed)))))
)
