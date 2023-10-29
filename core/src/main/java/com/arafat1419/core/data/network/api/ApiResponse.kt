package com.arafat1419.core.data.network.api

import com.arafat1419.core.vo.ErrorData

internal sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val error: ErrorData) : ApiResponse<Nothing>()
}