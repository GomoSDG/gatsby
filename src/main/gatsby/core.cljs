(ns gatsby.core
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [re-frame.core :as re-frame]
            [gatsby.views :as views]
            [gatsby.events :as events]
            [gatsby.subs :as subs]))

(defn mount-root []
  (js/console.log "Gatsby is running!")
  (re-frame/clear-subscription-cache!)
  (rdom/render [views/app-root]
               (.getElementById js/document "app")))


