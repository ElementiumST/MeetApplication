package io.stark.data

import retrofit2.Response

fun <T> Response<T>.bodyOrException() : T {
    if (isSuccessful && body() != null) {
        return body()!!
    } else if (!isSuccessful) {
        throw IllegalStateException("Request is success, but body is null")
    } else {
        throw IllegalStateException("Request does no success. message: ${message()}")
    }
}