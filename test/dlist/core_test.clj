(ns dlist.core-test
  (:require [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            [dlist.core :as d]))

(defspec t-list
  (prop/for-all
    [coll (gen/list gen/int)]
    (= coll (seq (d/list coll)))))

(defspec t-concat
  (prop/for-all
    [xs (gen/list gen/int)
     ys (gen/list gen/int)]
    (= (concat xs ys)
       (seq (d/concat (d/list xs) (d/list ys))))))
