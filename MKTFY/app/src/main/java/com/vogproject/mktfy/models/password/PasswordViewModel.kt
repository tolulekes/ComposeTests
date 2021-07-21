package com.vogproject.mktfy.models.password

import androidx.lifecycle.*

class PasswordViewModel: ViewModel() {

    private val _password = MutableLiveData<String>()
    val vPassword : LiveData<String> get() = _password

    private val _confirmPassword = MutableLiveData<String>()
    val vConfirmPassword : LiveData<String> get() = _confirmPassword


    val _errorcheck = MediatorLiveData<String>().apply {
        val observer = Observer<String> {
        value = if (_password.value == _confirmPassword.value) {
            null
        } else {
            "Passwords Do Not Match"
        }
    }
        addSource(_password, observer)
        addSource(_confirmPassword, observer)
    }

    val hasCharacters: LiveData<Boolean> get() = Transformations.map(_confirmPassword){
        it.length >= 6 && _errorcheck.value == null
    }

    val hasUppercase: LiveData<Boolean> get() = Transformations.map(_confirmPassword){
       it.contains(regex = Regex("(.[A-Z].)")) && _errorcheck.value == null
    }

    val hasNumber: LiveData<Boolean> get() = Transformations.map(_confirmPassword){
        it.contains(regex = Regex("(.\\.d)")) && _errorcheck.value == null
    }

    val strength = MediatorLiveData<Int>().apply {
        val observer = Observer<Boolean> {
            value = if(hasCharacters.value == true) 1 else 0 + if(hasUppercase.value == true) 1 else 0 + if(hasNumber.value == true) 1 else 0
        }
        addSource(hasCharacters, observer)
        addSource(hasUppercase, observer)
        addSource(hasNumber, observer)
    }
}