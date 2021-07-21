package com.vogproject.mktfy.models.createuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vog.mvvmdemo.general.Event
import com.vogproject.mktfy.models.EventType

class CreateUserViewModel(private val model: ICreateUserInterface): ViewModel() {

    private val _event = MutableLiveData<Event<EventType>>()
    val event : LiveData<Event<EventType>> get() = _event
    fun onEvent(eventType: EventType){
        _event.value = Event(eventType)
    }

//    private val _createUser = MutableLiveData<UserDetails>()
    val createUser = UserDetails()


}