package com.dashkevich.fast_food.screens.bottom.screens.model

import com.dashkevich.fast_food.data.api.model.PersonRequest

data class MainModel(
    val personRequest: PersonRequest? = null,
    val ready: Boolean = false
)
