(ns sudoku
  (:require [clojure.set :as set]))

(def board identity)

(def all-values #{1 2 3 4 5 6 7 8 9})

(defn value-at [board coord]
  (get-in board coord))

(defn has-value? [board coord]
  (not= 0 (value-at board coord)))

(defn row-values [board [row col]]
  (set (get board row)))

(defn col-values [board [row col]]
  (set (map (fn [r] (get r col)) board)))

(defn coord-pairs [coords]
  (for [x coords
        y coords]
    [x y]))

(defn top-left [[x y]]
  [(* (int (/ x 3)) 3) (* (int (/ y 3)) 3)])

(defn block-values [board coord]
  (let [[tlx tly] (top-left coord)]
    (set (map (fn [c] (value-at board c))
      (for [x (range tlx (+ tlx 3))
            y (range tly (+ tly 3))]
          [x y])))))

(defn valid-values-for [board coord]
  (if (has-value? board coord)
    #{}
    (set/difference all-values (block-values board coord) (row-values board coord) (col-values board coord))))

(defn filled? [board]
  (not (contains? (reduce set/union (map (fn [r] (row-values board r)) board)) 0)))

(defn rows [board]
  (map set board))

(defn valid-rows? [board]
  nil)

(defn cols [board]
  (for [c (range 0 9)]
    (col-values board [0 c])))

(defn valid-cols? [board]
  nil)

(defn blocks [board]
  nil)

(defn valid-blocks? [board]
  nil)

(defn valid-solution? [board]
  nil)

(defn set-value-at [board coord new-value]
  nil)

(defn find-empty-point [board]
  nil)

(defn solve [board]
  nil)
