package com.dashkevich.fast_food.data.api.model


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: Int?,
    @SerializedName("seed")
    val seed: String?,
    @SerializedName("version")
    val version: String?
)