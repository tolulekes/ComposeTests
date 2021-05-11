package com.example.viewmodeldemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int): ViewModel() {

    private var Total = MutableLiveData<Int>()
    val total: LiveData<Int>
    get() = Total

    init {
        Total.value = startingTotal
    }

    fun setTotal(Input:Int) {
        Total.value = (Total.value)?.plus(Input)
    }
}