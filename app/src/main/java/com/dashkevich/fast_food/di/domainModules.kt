package com.dashkevich.fast_food.di

import com.dashkevich.fast_food.data.repository.APIRepository
import com.dashkevich.fast_food.data.repository.APIRepositoryImpl
import org.koin.dsl.module

val domainModules = module {

    single<APIRepository> {
        APIRepositoryImpl(get())
    }

}