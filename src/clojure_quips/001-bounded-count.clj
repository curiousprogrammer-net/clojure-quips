(ns clojure-quips.001-bounded-count
  "Using `bounded-count` for lazy seqs.")

;; For small seqs we can use regular `count`
(count (range 10))


;; Let's say we want to check
;; if the input seq is greater than 10:
(< 10 (count (range 10)))

(< 10 (count (range 11)))

;; But what if we have lazy seq
;; of unknown length (potentially infinite)
#_(< 10 (count (range )))
;; ...
















;; Let's try with `bounded-count`
(< 10 (bounded-count 11 (range)))

(< 10 (bounded-count 11 (range 10)))

