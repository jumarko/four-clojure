(defproject four-clojure "0.1.0-SNAPSHOT"
  :description "My solutions to 4clojure.com problems."
  :url "https://github.com/jumarko/four-clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :main ^:skip-aot four-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
