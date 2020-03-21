(ns gatsby.components)

(defn income-item
  [value index]
  [:div.field
   [:label.label (str "Salary " index)]
   [:div.control
    [:input.input {:type "text"
                   :placeholder (str "Salary " index)
                   :value value}]]])

(defn income-list
  [incomes]
  [:<>
   [:h3.title.is-4 "Income"]
   (let [list-incomes (conj incomes "")]
     (map income-item list-incomes (map inc (range (count list-incomes)))))])
