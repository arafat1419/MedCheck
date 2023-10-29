package com.arafat1419.core.vo

import com.google.gson.annotations.SerializedName

data class ErrorData(
    val code: String? = null,
    @field:SerializedName("error")
    val message: String? = null
)
