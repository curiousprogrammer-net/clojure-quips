(ns clojure-quips.002-async-profiler
  (:require [clj-async-profiler.core :as prof]))

;;;; clj-async-profiler demo
;;;; See:
;;;; - Profiling tool: async-profiler: http://clojure-goes-fast.com/blog/profiling-tool-async-profiler/
;;;; - Github: https://github.com/clojure-goes-fast/clj-async-profiler
;;;; - Adds support for SVG's `width` and `height` options: https://github.com/clojure-goes-fast/clj-async-profiler/pull/10/






















(defn test-sum []
  (reduce + (map inc (range 1000))))


(defn test-div []
  (reduce / (map inc (range 1000))))

;; optimized with doubles
#_(defn test-div []
  (reduce / (map #(-> % inc double) (range 1000))))

(defn burn-cpu [secs]
  (let [start (System/nanoTime)]
    (while (< (/ (- (System/nanoTime) start) 1e9) secs)
      (test-sum)
      (test-div))))

(comment

  (prof/list-event-types)
  ;; => Basic events:
  ;;      cpu
  ;;      alloc
  ;;      lock
  ;;      wall
  ;;      itimer

  ;; start profiling
  (prof/start {})
  ;; or 
  (prof/start {:event :alloc})
  ;; then run the task
  (burn-cpu 10)
  ;; then stop the profiling
  (prof/stop {})

  ;; or profile the form itself (still system wide!)
  (prof/profile {:width 2400}
                (burn-cpu 10))

  (prof/serve-files 8888) 

  ;; end comment
  )
