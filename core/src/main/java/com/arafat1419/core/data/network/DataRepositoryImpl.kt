package com.arafat1419.core.data.network

import com.arafat1419.core.data.local.LocalDataSource
import com.arafat1419.core.data.network.api.ApiResponse
import com.arafat1419.core.data.network.datasource.NetworkDataSource
import com.arafat1419.core.data.network.param.AuthParam
import com.arafat1419.core.data.network.response.AuthResponse
import com.arafat1419.core.domain.model.AuthDomain
import com.arafat1419.core.domain.repository.DataRepository
import com.arafat1419.core.utils.DataMapper.toDomain
import com.arafat1419.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

internal class DataRepositoryImpl(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource
) : DataRepository {
    override fun login(param: AuthParam): Flow<Resource<AuthDomain>> =
        object : NetworkBoundResource<AuthDomain, AuthResponse>() {
            override fun shouldFetch(data: AuthDomain?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<AuthResponse>> =
                networkDataSource.login(param)

            override suspend fun load(data: AuthResponse): Flow<AuthDomain> =
                listOf(data.toDomain()).asFlow()
        }.asFlow()

    override fun register(param: AuthParam): Flow<Resource<AuthDomain>> =
        object : NetworkBoundResource<AuthDomain, AuthResponse>() {
            override fun shouldFetch(data: AuthDomain?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<AuthResponse>> =
                networkDataSource.register(param)

            override suspend fun load(data: AuthResponse): Flow<AuthDomain> =
                listOf(data.toDomain()).asFlow()
        }.asFlow()
}