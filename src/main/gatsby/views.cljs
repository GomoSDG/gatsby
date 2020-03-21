(ns gatsby.views
  (:require [re-frame.core :as re-frame]
            [gatsby.components :refer [income-list]]))

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
     [income-list [""]]]]])

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
