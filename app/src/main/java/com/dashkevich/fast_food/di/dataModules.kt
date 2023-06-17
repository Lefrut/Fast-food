package com.dashkevich.fast_food.di

import com.dashkevich.fast_food.data.api.API
import com.dashkevich.fast_food.data.api.EndPoints
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModules = module {

    single<Retrofit> {
        Retrofit.Builder().baseUrl(EndPoints.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    single<API> {
        get<Retrofit>().create(API::class.java)
    }

}