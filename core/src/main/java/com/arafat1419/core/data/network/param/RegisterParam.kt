package com.arafat1419.core.data.network.param

import com.google.gson.annotations.SerializedName

data class RegisterParam(
    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("password")
    val password: String,
)
