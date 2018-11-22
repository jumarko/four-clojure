(ns four-clojure.092-roman-numerals
  "http://www.4clojure.com/problem/92.
  Parse a Roman-numeral string and return the number it represents.
  You can assume that the input will be well-formed, in upper-case,
  and follow the subtractive principle: https://en.wikipedia.org/wiki/Roman_numerals#Subtractive_principle
  You don't need to handle any numbers greater than MMMCMXCIX (3999),
  the largest number representable with ordinary letters."
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.string :as str]))

(def romans {\I 1
             \V 5
             \X 10
             \L 50
             \C 100
             \D 500
             \M 1000})

(defn- roman-numberals [str-num]
  (->> str-num
       (str/upper-case)
       (map romans)
       (reduce + 0))
  )

(deftest simple-without-subtraction
  (testing "one"
    (is (= 1 (roman-numberals "I"))))
  (testing "two"
    (is (= 2 (roman-numberals "II"))))
  (testing "three"
    (is (= 3 (roman-numberals "III"))))
  (testing "five"
    (is (= 5 (roman-numberals "V"))))
  (testing "six"
    (is (= 6 (roman-numberals "VI"))))
  (testing "seven"
    (is (= 7 (roman-numberals "VII"))))
  (testing "eight"
    (is (= 8 (roman-numberals "VIII"))))
  (testing "longer"
    (is (= 1888 (roman-numberals "MDCCCLXXXVIII")))))
