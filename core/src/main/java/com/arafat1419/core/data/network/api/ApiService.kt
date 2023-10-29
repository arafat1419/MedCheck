package com.arafat1419.core.data.network.api

import com.arafat1419.core.data.network.param.AuthParam
import com.arafat1419.core.data.network.response.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

internal interface ApiService {
    @POST("login")
    suspend fun login(
        @Body request: AuthParam
    ): AuthResponse

    @POST("register")
    suspend fun register(
        @Body request: AuthParam
    ): AuthResponse
}