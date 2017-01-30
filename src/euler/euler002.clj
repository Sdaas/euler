(ns euler.euler002
	(use [clojure.string :only (split join triml)])
	(use [clojure.set :only (union)])
	(:gen-class))

; Euler Challenge #2 : Sum of Even Fibonacci numbers
; https://www.hackerrank.com/contests/projecteuler/challenges/euler002
;

(defn fibonacci-upto
	"generate the Fibonacci numbers upto (but not including) n"
	; it is assumed that the first two numbers are 1 and 2 respectively
	[n]

	(defn fibo
		[n-2 n-1 acc]
		(let [
			next (+' n-2 n-1)
			]
			(if (>= next n)
				acc
				(recur n-1 next (conj acc next)))))

	(cond
		(<= n 1) []
		(<= n 2) [1]
		(<= n 3) [1 2]
		:else (fibo 1 2 [1 2])))

(defn solve 
	"sum of all even fibonnaci numbers upto (but not including) n"
	[n]
	(reduce + (filter even? (fibonacci-upto n))))

(defn read-n
	"read n elements from stdin into a vector"
	[n]
	(loop [
			x n 
			acc []
		]
		(if (= x 0)
			acc
			(recur (dec x) (conj acc (read-line))))))

(defn -main
	"The main ..."
	[& args]
	(let [
		number-of-inputs  (Integer/parseInt (read-line))
		inputs 		(map #(bigint %) (read-n number-of-inputs))
		ans         (map solve inputs)
		]
		;(println "hello")))
		(doseq [item ans] (println item))))
