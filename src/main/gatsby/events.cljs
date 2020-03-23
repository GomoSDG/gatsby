(ns gatsby.events
  (:require [re-frame.core :as re]))

;; -- handlers -------------------------------------------------------------------------
(defn update-salary-item
  [coeffects event]
  (let [[type index val] event
        db (:db coeffects)
        salaries (:salaries db)
        new-salaries (assoc (vec salaries) index (float val))]
    {:db (assoc db :salaries new-salaries)}))

(defn add-salary
  [coeffects event]
  (let [db (:db coeffects)
        salaries (:salaries db)]
    {:db (assoc db :salaries (cons 0 salaries))}))

; -- Event registrations
(re/reg-event-fx
 :update-salary
 update-salary-item)

(re/reg-event-fx
 :add-salary
 add-salary)

