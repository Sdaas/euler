(ns euler.euler001
	(use [clojure.string :only (split join triml)])
	(:gen-class))

; Euler Challenge #1 : Multiples of 3 and 5
; https://www.hackerrank.com/contests/projecteuler/challenges/euler001
;
; Find the sum of all the multiples of 3 or 5 below N

(defn multiple
	"Sum of all multiples of 3 and 5 below n"
	[n]
	(let [
		data (range n)
		multiples (filter #(or (= 0 (rem % 3)) (= 0 (rem % 5))) data)
		]
		(reduce + multiples)))

(defn -main
	"I don't do a whole lot ... yet."
	[& args]
	(println "Hello, World!"))
