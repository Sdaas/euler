(ns euler.euler001
	(use [clojure.string :only (split join triml)])
	(use [clojure.set :only (union)])
	(:gen-class))

; Euler Challenge #1 : Multiples of 3 and 5
; https://www.hackerrank.com/contests/projecteuler/challenges/euler001
;
; Find the sum of all the multiples of 3 or 5 below N

; The sum of all multiples of m less than n is given by
; sum(k= 1 to L)(m*k)
; where L is the number of multiples less than n. i.e., L = n div m
; which reduces to m.(L)(L+1)/2
(defn solve
	[m n]
	(let [
		nn  (dec n)
		ell	(quot nn m)
		]
		(/ (* m (* ell (inc ell))) 2)))

(defn sum-of-multiples
	"Sum of all multiples of 3 and 5 below n"
	[n]
	(let [
		sum-3x  (solve 3 n)
		sum-5x  (solve 5 n)
		sum-15x (solve 15 n)
		]
		(- (+ sum-3x sum-5x) sum-15x)))

; O(N) solution ...
(defn slow-sum-of-multiples
	"Sum of all multiples of 3 and 5 below n"
	[n]
	(let [
		data (range n)
		multiples (filter #(or (= 0 (rem % 3)) (= 0 (rem % 5))) data)
		]
		(reduce + multiples)))

; Also O(N) solution. Turns out that this is 3x slower than sum-of-multiples
(defn slower-sum-of-multiples
	"Sum of all multiples of 3 and 5 below n"
	[n]
	(let [
		multiples-3  (into #{} (range 3 n 3))
		multiples-5  (into #{} (range 5 n 5))
		multiples-of-both (union multiples-3 multiples-5)
		]
		(reduce + multiples-of-both)))

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
		inputs 		(map #(Integer/parseInt %) (read-n number-of-inputs))
		multiples 	(map #(sum-of-multiples %) inputs)
		]
		(doseq [item multiples] (println item))))
