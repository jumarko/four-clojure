(ns four-clojure.053-longest-increasing-subseq
  "http://www.4clojure.com/problem/53.
  Given a vector of integers, find the longest consecutive sub-sequence of increasing numbers.
  If two sub-sequences have the same length, use the one that occurs first.
  An increasing sub-sequence must have a length of 2 or greater to qualify."
  (:require [clojure.test :as t]))

(defn longest-increasing-subseq [numbers]
  (first
   (reduce
    (fn [[longest-seq current-seq] current-number]
      (let [previous-number (peek current-seq)]
        (if (or (nil? previous-number)
                (< previous-number current-number))
          ;; keep building current-seq
          [longest-seq (conj current-seq current-number)]
          (if (> (count current-seq) (count longest-seq))
            [current-seq []]
            ;; notice that if both seqs have equal size than the first one is returned
            [longest-seq []]))))
    [[] []]
    numbers)))

(longest-increasing-subseq [1 2 0])

;;; tests
(t/deftest longest-subseq
  (t/testing "trivial single sequence"
    (t/is (= [1 2]
             (longest-increasing-subseq [1 2 0])))))
