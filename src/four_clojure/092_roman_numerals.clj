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

(defn roman-numberals [str-num]
  (let [numbers (->> str-num
                     (str/upper-case)
                     (map romans))]
    (loop [total 0
           nums numbers]
      (let [[fst snd] nums]
        (cond
          (and fst snd)
          (if (< fst snd)
            ;; this is subtraction pattern
            (recur (+ total (- snd fst)) (nnext nums))
            ;; add only the first one because the second one can form subtraction pattern with the third element
            (recur (+ total fst) (next nums)))

          fst
          (+ total fst)

          :else
          total)))))

(deftest simple-without-subtraction
  (testing "none"
    (is (= 0 (roman-numberals ""))))
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

(deftest subtraction
  (testing "four"
    (is (= 4 (roman-numberals "IV"))))
  (testing "nine"
    (is (= 9 (roman-numberals "IX"))))
  (testing "longer"
    (is (= 999 (roman-numberals "CMXCIX")))))


(deftest official-tests
  (testing "simple with subtraction"
    (is (= 14 (roman-numberals "XIV"))))
  (testing "longer but no subtraction"
    (is (= 827 (roman-numberals "DCCCXXVII"))))
  (testing "Long and subtraction"
    (is (= 3999 (roman-numberals "MMMCMXCIX"))))
  (testing "Subtraction from L"
    (is (= 48 (roman-numberals "XLVIII")))))

