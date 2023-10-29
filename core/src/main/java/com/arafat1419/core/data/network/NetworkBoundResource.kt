package com.arafat1419.core.data.network

import com.arafat1419.core.data.network.api.ApiResponse
import com.arafat1419.core.vo.ErrorData
import com.arafat1419.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

internal abstract class NetworkBoundResource<ResultType, RequestType> {
    private var result: Flow<Resource<ResultType>> = flow {
        try {
            emit(Resource.Loading())
            val dbSource = loadFromDB()?.first()

            if (shouldFetch(dbSource)) {
                emit(Resource.Loading())
                when (val apiResponse = createCall()!!.first()) {
                    is ApiResponse.Success -> {
                        saveCallResult(apiResponse.data)

                        load(apiResponse.data)?.let { emitAll(it.map { data -> Resource.Success(data) }) }
                    }
                    is ApiResponse.Error -> {
                        onFetchFailed()
                        emit(Resource.Error(apiResponse.error))
                    }
                }
            } else {
                loadFromDB()?.let {
                    emitAll(it.map { data ->
                        Resource.Success(data)
                    })
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error(ErrorData("500", e.message)))
        }
    }

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected open suspend fun createCall(): Flow<ApiResponse<RequestType>>? = null

    protected open suspend fun load(data: RequestType): Flow<ResultType>? = null

    protected open fun loadFromDB(): Flow<ResultType>? = null

    protected open suspend fun saveCallResult(data: RequestType) {}

    protected open fun onFetchFailed() {}

    fun asFlow(): Flow<Resource<ResultType>> = result
}