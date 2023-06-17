package com.dashkevich.fast_food.data.repository

import com.dashkevich.fast_food.data.api.API
import com.dashkevich.fast_food.data.api.model.PersonRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class APIRepositoryImpl(val api: API): APIRepository {

    override suspend fun getPersons(): Result<PersonRequest> {
        return coroutineCatching(Dispatchers.IO){
            api.getResults()
        }
    }
}

suspend fun <T> coroutineCatching(
    dispatcher: CoroutineDispatcher,
    call: suspend () -> T
): Result<T> = runCatching {
    withContext(dispatcher) {
        call.invoke()
    }
}