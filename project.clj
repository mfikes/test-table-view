(defproject test-table-view "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [org.omcljs/om "0.9.0"]
                 [org.omcljs/ambly "0.6.0"]
                 [natal-shell "0.1.0"]]
 :plugins [[lein-cljsbuild "1.1.1"]]
 :cljsbuild {:builds {:dev {:source-paths ["src"]
                            :compiler {:output-to "target/out/main.js"
                                       :output-dir "target/out"
                                       :optimizations :none}}}})