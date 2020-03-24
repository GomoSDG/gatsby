(ns gatsby.views
  (:require [re-frame.core :as re]
            [gatsby.components :refer [money-summary]]))

(defn nav-bar
  []
  [:nav.navbar.has-shadow.is-spaced.bd-navbar {:role "navigation"
                :aria-label "main navigation"}
   [:div.navbar-brand
    [:a.navbar-item {:href "#"}
     [:h1 "Gatsby"]]]])

(defn home
  []
  [:<>
   [:div.columns
    [:div.column.is-one-quarter
     [money-summary "Income" "Income" @(re/subscribe [:salaries]) :add-income :delete-income :update-income]]
    [:div.column.is-one-quarter
     [money-summary "Expenses" "Expense" @(re/subscribe [:expenses]) :add-expense :delete-expense :update-expense]]]])

(defn app-view
  [page-id]
  (case page-id
    :home
    [home]))

(defn app-root
  []
  [:<>
   [nav-bar]
   [:section.container  (app-view :home)]])
