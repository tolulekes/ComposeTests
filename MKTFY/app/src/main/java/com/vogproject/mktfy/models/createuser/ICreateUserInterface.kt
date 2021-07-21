package com.vogproject.mktfy.models.createuser

interface ICreateUserInterface {
    suspend fun getUserDetails(): List<UserDetails>
    suspend fun createUserDetails(userDetails: UserDetails)
}