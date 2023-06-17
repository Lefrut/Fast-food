package com.dashkevich.fast_food.data.repository

import com.dashkevich.fast_food.data.api.model.PersonRequest

interface APIRepository {

    suspend fun getPersons(): Result<PersonRequest>

}