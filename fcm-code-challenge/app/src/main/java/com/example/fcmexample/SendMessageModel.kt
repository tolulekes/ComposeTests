package com.example.fcmexample

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class SendMessageModel : BaseObservable() {
    @get:Bindable
    var title: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }


    @get:Bindable
    var topic: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.topic)
        }

    @get:Bindable
    var message: String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.message)
    }

    @get:Bindable
    var sendAsNotificationMessage = false
    set(value) {
        field = value
        notifyPropertyChanged(BR.sendAsNotificationMessage)
    }
}