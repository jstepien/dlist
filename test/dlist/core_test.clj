(ns dlist.core-test
  (:require [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.walk :as walk]
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

(def gen-tree
  (gen/recursive-gen gen/vector
                     (gen/fmap list gen/int)))

(def tree->seq flatten)

(defn tree->dlist [tree]
  (walk/postwalk (fn [form]
                   (cond (list? form)   (d/list form)
                         (= [] form)    (d/list)
                         (vector? form) (reduce d/concat form)
                         :else          form))
                 tree))

(defspec t-recursive
  (prop/for-all
    [tree gen-tree]
    (= (tree->seq tree) (seq (tree->dlist tree)))))
