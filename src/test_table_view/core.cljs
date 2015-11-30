(ns test-table-view.core
  (:require [om.core :as om])
  (:require-macros [natal-shell.components :refer [view text image touchable-highlight]]
                   [natal-shell.alert-ios :refer [alert]]))

(set! js/React (js/require "react-native/Libraries/react-native/react-native.js"))

(def TableView (js/require "react-native-tableview/index.js"))
(def Section TableView.Section)
(def Item TableView.Item)

(defn tableview [opts & children]
  (apply js/React.createElement
    TableView (clj->js opts) children))

(defn section [opts & children]
  (apply js/React.createElement
    Section (clj->js opts) children))

(defn item [opts & children]
  (apply js/React.createElement
    Item (clj->js opts) children))

(defonce app-state (atom {:text "Welcome to TestTableView1"}))

(defn widget [data owner]
  (reify
    om/IRender
    (render [this]
      (try
        (tableview
          {:style              {:flex 1}
           :tableViewStyle     TableView.Consts.Style.Grouped
           :tableViewCellStyle TableView.Consts.CellStyle.Subtitle
           :onPress            (fn [event] (prn event))}
          (section
            {:label "Section 1"
             :arrow true}
            (item {:value  "1"
                   :detail "Creator"} "Rich")
            (item {:value "2"} "David")
            (item nil "Stuart")
            (item nil "John")
            (item nil "Mike"))
          (section
            {:label "Section 2"
             :arrow false}
            (item {:selected  true} "ClojureScript")
            (item nil "Ambly")
            (item nil "Natal")))

        (catch :default e
          (view {:style {:backgroundColor "#cc0814" :flex 1 :padding 20 :paddingTop 40}}
            (text
              {:style {:fontWeight "normal" :color "white" :fontSize 24 :marginBottom 10}}
              "ERROR")
            (text
              {:style {:color "white" :fontFamily "Menlo-Regular" :fontSize 16 :lineHeight 24}}
              (.-message e))
            (text
              {:style {:color "white" :marginTop 20 :fontSize 16 :fontWeight "bold"}}
              "Check REPL log for details.")))))))


(om/root widget app-state {:target 1})

(defn ^:export init []
  ((fn render []
     (.requestAnimationFrame js/window render))))
