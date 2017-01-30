(defproject euler "0.1.0-SNAPSHOT"
  :description "Hacker Rank's Euler+ Challenge"
  :url "https://www.hackerrank.com/contests/projecteuler/challenges"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot euler.euler002
  :target-path "target/%s"
  :plugins [[lein-gorilla "0.4.0"]]
  :profiles {:uberjar {:aot :all}})
