package com.dashkevich.fast_food.data.api.model


import com.google.gson.annotations.SerializedName

data class PersonRequest(
    @SerializedName("info")
    val info: Info?,
    @SerializedName("results")
    val results: List<Result?>?
)