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
		(is (= 0 (multiple 2)))
		(is (= 0 (multiple 3)))  ; _below_ 3 => not including 3
		(is (= 3 (multiple 4)))
		(is (= 3 (multiple 5)))
		(is (= 8 (multiple 6)))
		(is (= 23 (multiple 10)))
		(is (= 2318 (multiple 100)))))