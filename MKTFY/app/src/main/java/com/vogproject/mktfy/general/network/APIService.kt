package com.vogproject.mktfy.general.network

import com.vogproject.mktfy.models.faq.FAQTopic
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface APIService {

    //GET Joke
    @GET("joke/{categories}")
    suspend fun getJoke(
        @Path("categories") categories: String,
        @Query("blacklistFlags") blacklistFlags: String,
        @Query("type") type: String = "twopart"
    ): FAQTopic

}