(ns euler.euler001-test
  (:require [clojure.test :refer :all]
            [euler.euler001 :refer :all]))

;Note that the test must be in a XXX_test file (underscore)
;
;To run all tests in project
;  lein test
;
;To run all tests for euler001.clj
;	lein test euler.euler001-test
;
;To run only a specific test
;   lein test :only euler.euler001-test/foo
;

(deftest multiple-test
	(testing "sum of all numbers below N that are multiples of 3 or 5"
		(is (= 0 (sum-of-multiples 2)))
		(is (= 0 (sum-of-multiples 3)))  ; _below_ 3 => not including 3
		(is (= 3 (sum-of-multiples 4)))
		(is (= 3 (sum-of-multiples 5)))
		(is (= 8 (sum-of-multiples 6)))
		(is (= 23 (sum-of-multiples 10)))
		(is (= 2318 (sum-of-multiples 100)))))