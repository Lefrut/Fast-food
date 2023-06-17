package com.dashkevich.fast_food

import android.app.Application
import com.dashkevich.fast_food.di.dataModules
import com.dashkevich.fast_food.di.domainModules
import com.dashkevich.fast_food.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class FastFoodApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@FastFoodApplication)
            modules(dataModules, domainModules, viewModelModules)
        }
    }

}