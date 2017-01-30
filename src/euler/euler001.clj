(ns euler.euler001
	(use [clojure.string :only (split join triml)])
	(use [clojure.set :only (union)])
	(:gen-class))

; Euler Challenge #1 : Multiples of 3 and 5
; https://www.hackerrank.com/contests/projecteuler/challenges/euler001
;
; Find the sum of all the multiples of 3 or 5 below N

(defn sum-of-multiples
	"Sum of all multiples of 3 and 5 below n"
	[n]
	(let [
		data (range n)
		multiples (filter #(or (= 0 (rem % 3)) (= 0 (rem % 5))) data)
		]
		(reduce + multiples)))

; The slower approach. Turns out that this is 3x slower than sum-of-multiples
(defn slow-sum-of-multiples
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
