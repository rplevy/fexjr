(ns fexjr.test.core
  (:use [fexjr.core]
        [midje.sweet]))

(defvau fooxpr [foo] [foo " = " (eval foo)])

(facts
 ((fooxpr (+ 1 2))) => ['(+ 1 2) " = " 3]
 ($ (fooxpr (+ 1 2))) => ['(+ 1 2) " = " 3])

(def a 5)

(defvau fooxbar [foo bar] [(str foo " = " (eval foo)) (when bar (reverse bar))])

(facts
 ((fooxbar (+ 1 2 a) [f e d])) => ["(+ 1 2 a) = 8" '[d e f]]
 ($ (fooxbar (+ 1 2 a) [f e d])) => ["(+ 1 2 a) = 8" '[d e f]])

(comment
  (defvau foo [x y x]
    (if (true? (evil e x) 0)
      (evil e y)
      (evil e z))))


