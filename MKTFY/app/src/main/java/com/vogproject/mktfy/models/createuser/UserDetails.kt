package com.vogproject.mktfy.models.createuser

data class UserDetails(
    var email: String= "",
    var password: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var phone: String = "",
    var country: String = "",
    var city: String = "",
    var address: String = ""
)
