package com.arafat1419.core.data.network.datasource

import com.arafat1419.core.data.network.api.ApiResponse
import com.arafat1419.core.data.network.api.ApiService
import com.arafat1419.core.data.network.param.AuthParam
import com.arafat1419.core.data.network.response.AuthResponse
import com.arafat1419.core.vo.ErrorData
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException

internal class NetworkDataSource(private val apiService: ApiService) {

    suspend fun login(param: AuthParam): Flow<ApiResponse<AuthResponse>> =
            networkHandler {
                apiService.login(param)
            }

    suspend fun register(param: AuthParam): Flow<ApiResponse<AuthResponse>> =
        networkHandler {
            apiService.register(param)
        }

    private suspend fun <T> networkHandler(responseCall: suspend () -> T): Flow<ApiResponse<T>> =
        flow {
            try {
                val response = responseCall()

                if (response != null) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Error(ErrorData("204", "Data is empty")))
                }
            } catch (e: Exception) {
                when (e) {
                    is HttpException -> {
                        val responseBody = e.response()?.errorBody()?.string()
                        val errorResponse =
                            Gson().fromJson(responseBody, ErrorData::class.java)
                        emit(
                            ApiResponse.Error(
                                ErrorData(
                                    e.response()?.code().toString(),
                                    errorResponse.message
                                )
                            )
                        )
                    }
                    else -> {
                        emit(ApiResponse.Error(ErrorData(null, e.message)))
                    }
                }
            }
        }.flowOn(Dispatchers.IO)
}