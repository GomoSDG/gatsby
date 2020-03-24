(ns gatsby.subs
  (:require [re-frame.core :as re]))

;; -- Query Functions -----------------------------------------------
(re/reg-sub
 :salaries
 (fn [db _]
   (:salaries db)))

(re/reg-sub
 :expenses
 (fn [db _]
  (:expenses db)))
