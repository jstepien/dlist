(ns dlist.core
  (:refer-clojure :exclude [concat list]))

(deftype DList [f]
  clojure.lang.IFn
  (invoke [_ tail]
    (f tail))
  clojure.lang.Seqable
  (seq [_]
    (f ())))

(defn singleton [x]
  (DList. #(cons x %)))

(defn concat [xs ys]
  (DList. #(xs (ys %))))

(defn list
  ([]
   (DList. identity))
  ([coll]
   (reduce (fn [dlist elem] (concat dlist (singleton elem)))
           (list)
           coll)))
