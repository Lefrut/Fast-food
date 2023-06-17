package com.dashkevich.fast_food.util


fun <T> Result<T>.resultHandler(
    onLoading: () -> Unit = {},
    onSuccess: (T) -> Unit = {},
    onError: (String) -> Unit = {},
    onEmptyResult: (T) -> Unit = {},
) {
    onLoading()
    onFailure {
        onError(it.message.toString())
    }
    onSuccess {
        when (it) {
            is Collection<*> -> {
                if (it.isEmpty()) {
                    onEmptyResult(it)
                } else {
                    onSuccess(it)
                }
            }
            null -> {
                onEmptyResult(it)
            }
            else -> {
                onSuccess(it)
            }
        }
    }
}