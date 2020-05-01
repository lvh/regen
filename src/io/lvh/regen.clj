(ns io.lvh.regen
  (:require
   [clojure.java.io :as io]
   [cheshire.core :as json]
   [clojure.test.check.generators :as gen]
   [com.gfredericks.test.chuck.generators :as gen'])
  (:gen-class))

(defn replace-regexes-with-samples
  [m]
  (->>
   (for [[k regex] m
         :let [gen (gen'/string-from-regex (re-pattern regex))
               samples (into #{} (gen/sample gen 20))]]
     [k samples])
   (into {})))

(defn -main
  "Read JSON from stdin, replace map values (regexes) with samples matching said
  regex."
  [& args]
  (-> *in*
      io/reader
      json/parse-stream
      replace-regexes-with-samples
      (json/generate-stream *out*)))
