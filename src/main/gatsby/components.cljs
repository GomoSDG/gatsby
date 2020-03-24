(ns gatsby.components
  (:require [re-frame.core :as re]))

;; -- Income Item Component ----------------------------------------------------------------------------------

(defn money-summary-item
  [title value update-event delete-event]
  (let []
    [:div.field.has-addons
     [:p.control
      [:a.button.is-static
       "R"]]
     [:div.control
      [:input.input {:type "number"
                     :placeholder (str "Income")
                     :value (get value 1)
                     :on-change #(re/dispatch [update-event (first value) (-> % .-target .-value int)])}]]
     [:div.control
      [:a.button.is-danger.is-light {:on-click #(re/dispatch [delete-event (first value)])}
       [:i.fas.fa-minus]]]]))

;; -- Income List Component ----------------------------------------------------------------------------------

(defn money-summary
  [title placeholder values add-event delete-event update-event]
  [:div
   [:div.level {:style {:margin-bottom 0}}
    [:div.level-left
     [:div.level-item
      [:h1.title.is-4 {:style {:margin-bottom 0}}
       title]]]
    [:div.level-right
     [:div.level-item
      [:button.button.is-success.is-light {:on-click #(re/dispatch [add-event])}
       [:i.fas.fa-plus]]]]]
   [:hr {:style {:margin-top 0}}]
   [:div.is-divider]
   (map #(money-summary-item placeholder % update-event delete-event) values)
   [:hr {:style {:margin-bottom 0}}]
   [:span.subtitle (str "Total: " (reduce + (vals values)))]])

;; -- modal ---------------------------------------------------------------------------
(defn modal
  [title modal-content footer-actions]
  [:div.modal
   [:div.modal-background]
   [:div.modal-card
    [:header.modal-card-head
     [:p.modal-card-title title]
     [:button.delete {:aria-label "close"}]]
    [:section.modal-card-body
     [modal-content]]
    [:footer.modal-card-foot
     (map footer-action footer-actions)]]])

;; -- Money Summary Modal Content --------------------------------------------------------------------
