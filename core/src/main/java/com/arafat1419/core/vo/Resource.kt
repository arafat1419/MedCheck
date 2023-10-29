package com.arafat1419.core.vo

sealed class Resource<T>(val data: T? = null, val error: ErrorData? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(error: ErrorData, data: T? = null) : Resource<T>(data, error)
}