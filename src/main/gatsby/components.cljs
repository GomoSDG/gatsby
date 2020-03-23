(ns gatsby.components
  (:require [re-frame.core :as re]))

(defn income-item
  [value index]
  (let [pos (inc index)]
    [:div.field
     [:label.label (str "Salary " pos)]
     [:div.control
      [:input.input {:type "number"
                     :placeholder (str "Salary" (inc index))
                     :value value
                     :on-change #(re/dispatch [:update-salary index (-> % .-target .-value int)])}]]]))

(defn income-list
  [incomes]
  (js/console.log (clj->js  (map int incomes)))
  [:div
   [:div.level {:style {:margin-bottom 0}}
    [:div.level-left
     [:div.level-item
      [:h1.title.is-4 {:style {:margin-bottom 0}}
       "Income"]]]
    [:div.level-right
     [:div.level-item
      [:button.button.is-success.is-light {:on-click #(re/dispatch [:add-salary])}
       [:i.fas.fa-plus]]]]]
   [:hr {:style {:margin-top 0}}]
   [:div.is-divider]
   (map income-item incomes (range (count incomes)))
   [:hr {:style {:margin-bottom 0}}]
   [:span.subtitle (str "Total: " (reduce + incomes))]])
