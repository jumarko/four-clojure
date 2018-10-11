(ns four-clojure.070-word-sorting
  "Write a function that splits a sentence up into a sorted list of words.
  Capitalization should not affect sort order and punctuation should be ignored.
  See http://www.4clojure.com/problem/70")

(defn sorted-words [sentence]
  (letfn [(case-insensitive-comp [x y]
            (compare (clojure.string/upper-case x)
                     (clojure.string/upper-case y)))]
    (->> (clojure.string/split sentence #"[^A-Za-z]+")
         (sort case-insensitive-comp))))

(sorted-words "Have a nice day.")

(sorted-words "Clojure is a fun language!")

(sorted-words "Fools fall for foolish follies.")
