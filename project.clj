(defproject clojure-quips "0.1.0-SNAPSHOT"
  :description "Examples for the 'Clojure Quips' screencast"
  :url "https://curiousprogrammer.net/clojure-quips/"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot clojure-quips.core
  :target-path "target/%s"
  ;; allowAttachSelf is necessary for Dynamic Attach on Java 9+ used by clj-async-profiler: https://github.com/clojure-goes-fast/clj-async-profiler#usage)
  :jvm-opts ["-Djdk.attach.allowAttachSelf=true"]
  :profiles {:uberjar {:aot :all}})
