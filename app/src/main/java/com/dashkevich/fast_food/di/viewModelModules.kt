package com.dashkevich.fast_food.di

import com.dashkevich.fast_food.screens.bottom.screens.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModules = module {
    viewModel {
        MainViewModel(get())
    }
}