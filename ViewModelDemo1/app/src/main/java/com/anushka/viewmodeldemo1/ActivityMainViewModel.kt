package com.anushka.viewmodeldemo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityMainViewModel: ViewModel() {

    private var count = MutableLiveData<Int>()
    var Count: LiveData<Int> = count

    init {
        count.value = 0
    }

    fun updateCount (){
        count.value = (count.value)?.plus(1)
    }

}