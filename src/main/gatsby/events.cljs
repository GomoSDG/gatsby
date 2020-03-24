(ns gatsby.events
  (:require [re-frame.core :as re]))

;; -- handlers -------------------------------------------------------------------------
(defn update-income-item
  [coeffects event]
  (let [[type id val] event
        db (:db coeffects)]
    {:db (assoc-in db [:salaries id] val)}))

(defn update-expense
  [coeffects event]
  (let [[type id val] event
        db (:db coeffects)]
    {:db (assoc-in db [:expenses id] val)}))

(defn delete-income
  [coeffects event]
  (let [[type id] event
        db (:db coeffects)]
    {:db (update db :salaries #(dissoc % id))}))

(defn delete-expense
  [coeffects event]
  (let [[type id] event
        db (:db coeffects)]
    {:db (update db :expenses #(dissoc % id))}))


(defn add-expense
  [coeffects event]
  (let [db (:db coeffects)]
    {:db (assoc-in db [:expenses (.now js/Date)] nil)}))

(defn add-income
  [coeffects event]
  (let [db (:db coeffects)]
    {:db (assoc-in db [:salaries (.now js/Date)] nil)}))

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

(re/reg-event-fx
 :update-expense
 update-expense)

(re/reg-event-fx
 :add-expense
 add-expense)

(re/reg-event-fx
 :delete-expense
 delete-expense)
