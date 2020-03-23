(ns gatsby.components
  (:require [re-frame.core :as re]))

;; -- Income Item Component ----------------------------------------------------------------------------------

(defn income-item
  [income]
  (js/console.log (clj->js  ["value" (get income 1)]))
  (let []
    [:div.field.has-addons
     [:p.control
      [:a.button.is-static
       "R"]]
     [:div.control
      [:input.input {:type "number"
                     :placeholder (str "Income")
                     :value (get income 1)
                     :on-change #(re/dispatch [:update-income (first income) (-> % .-target .-value int)])}]]
     [:div.control
      [:a.button.is-danger.is-light {:on-click #(re/dispatch [:delete-income (first income)])}
       [:i.fas.fa-minus]]]]))

;; -- Income List Component ----------------------------------------------------------------------------------

(defn income-list
  [incomes]
  (js/console.log (clj->js  incomes))
  [:div
   [:div.level {:style {:margin-bottom 0}}
    [:div.level-left
     [:div.level-item
      [:h1.title.is-4 {:style {:margin-bottom 0}}
       "Income"]]]
    [:div.level-right
     [:div.level-item
      [:button.button.is-success.is-light {:on-click #(re/dispatch [:add-income])}
       [:i.fas.fa-plus]]]]]
   [:hr {:style {:margin-top 0}}]
   [:div.is-divider]
   (map income-item incomes)
   [:hr {:style {:margin-bottom 0}}]
   [:span.subtitle (str "Total: " (reduce + (vals incomes)))]])
