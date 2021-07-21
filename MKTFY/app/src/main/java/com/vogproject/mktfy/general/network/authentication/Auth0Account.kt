package com.vogproject.mktfy.general.network.authentication

import com.auth0.android.Auth0
import com.auth0.android.Auth0Exception
import com.auth0.android.authentication.AuthenticationAPIClient
import com.auth0.android.callback.Callback
import com.auth0.android.request.DefaultClient
import com.auth0.android.result.DatabaseUser
import com.vogproject.mktfy.models.createuser.UserDetails
import com.vogproject.mktfy.ui.login.LoginActivity
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class Auth0Account(context: LoginActivity) {

    private val account = Auth0(context).apply {
        networkingClient = DefaultClient(enableLogging = true)
    }
    private val authenticationAPIClient = AuthenticationAPIClient(account)

    class GenericCallback<T, U: Auth0Exception>(private val continuation: Continuation<T>) :
        Callback<T, U> {
        override fun onFailure(error: U) {
            continuation.resumeWithException(error)
        }
        override fun onSuccess(result: T) {
            continuation.resume(result)
        }
    }

    suspend fun createUser(userDetails: UserDetails) = suspendCoroutine<DatabaseUser> {continuation ->
        authenticationAPIClient.createUser(
            userDetails.email,
            userDetails.password,
            "${userDetails.firstName} ${userDetails.lastName}",
            "Username-Password-Authentication",
            mapOf(
                "firstName" to userDetails.firstName,
                "lastName" to userDetails.lastName,
                "phone" to userDetails.phone,
                "country" to userDetails.country,
                "city" to userDetails.city,
                "address" to userDetails.address,
            )
        ).start(GenericCallback(continuation))
    }
}