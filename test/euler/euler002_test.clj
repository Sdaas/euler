(ns euler.euler002-test
  (:require [clojure.test :refer :all]
            [euler.euler002 :refer :all]))

;Note that the test must be in a XXX_test file (underscore)
;
;To run all tests in project
;  lein test
;
;To run all tests for euler002.clj
;	lein test euler.euler002-test
;
;To run only a specific test
;   lein test :only euler.euler002-test/foo
;

(deftest fibo-test
	(testing "generate the fibonacci numbers upto (but not including) n"
		(is (= '() (fibonacci-upto 1)))
		(is (= '(1) (fibonacci-upto 2)))
		(is (= '(1 2) (fibonacci-upto 3)))
		(is (= '(1 2 3 5) (fibonacci-upto 6)))
		(is (= '(1 2 3 5 8 13) (fibonacci-upto 21)))))

(deftest solve-test
	(testing "sum of all fibonacci numbers upto (but not including) n"
		(is (= 10 (solve 10)))
		(is (= 44 (solve 100))))
	(testing "for really large numbers"
		(is (= 6293134512 (solve 10000000000))) ; 10^10
		(is (= 11708364174233842 (solve 10000000000000000))) ; 10^16
		(is (= 49597426547377748 (solve 40000000000000000))))) ; 4x10^16
	
