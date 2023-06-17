package com.dashkevich.fast_food.data.api

import com.dashkevich.fast_food.data.api.model.PersonRequest
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("api/")
    suspend fun getResults(@Query("results") results: Int = 50): PersonRequest
}