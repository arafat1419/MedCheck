package com.arafat1419.core.domain.repository

import com.arafat1419.core.data.network.param.AuthParam
import com.arafat1419.core.domain.model.AuthDomain
import com.arafat1419.core.vo.Resource
import kotlinx.coroutines.flow.Flow

internal interface DataRepository {
    fun login(param: AuthParam): Flow<Resource<AuthDomain>>
    fun register(param: AuthParam): Flow<Resource<AuthDomain>>
}