(ns gatsby.events
  (:require [re-frame.core :as re]))

;; -- handlers -------------------------------------------------------------------------
(defn update-income-item
  [coeffects event]
  (let [[type id val] event
        db (:db coeffects)]
    {:db (assoc-in db [:salaries id] val)}))

(defn delete-income
  [coeffects event]
  (js/console.log (clj->js event))
  (let [[type id] event
        db (:db coeffects)]
    (js/console.log (clj->js (:salaries db)))
    {:db (update db :salaries #(dissoc % id))}))

(defn add-income
  [coeffects event]
  (let [db (:db coeffects)
        salaries (:salaries db)]
    {:db (assoc-in db [:salaries (.now js/Date)] 0)}))

; -- Event registrations
(re/reg-event-fx
 :update-income
 update-income-item)

(re/reg-event-fx
 :add-income
 add-income)

(re/reg-event-fx
 :delete-income
 delete-income)

