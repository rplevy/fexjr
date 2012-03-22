(ns fexjr.core
  (:use [evalive.core :only [evil]]))

(defmacro defvau [fname [& arg-vec] & body]
  (let [sym-names (vec (map (comp symbol name) arg-vec))]
    `(defmacro ~fname [~@arg-vec]
       (let [~'args-str (str [~@arg-vec])]
         (list 'fn []
               (list 'let
                     (vector
                      '~sym-names
                      (list 'read-string ~'args-str))
                     (list 'do '~@body)))))))

(defmacro $
  "([e & body] TODO: walk the body and put env in any evils)"
  [& body]
  `(~@body))
