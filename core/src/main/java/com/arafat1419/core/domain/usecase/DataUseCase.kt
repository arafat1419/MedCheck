package com.arafat1419.core.domain.usecase

import com.arafat1419.core.data.network.param.AuthParam
import com.arafat1419.core.domain.model.AuthDomain
import com.arafat1419.core.vo.Resource
import kotlinx.coroutines.flow.Flow

interface DataUseCase {
    fun login(param: AuthParam): Flow<Resource<AuthDomain>>
    fun register(param: AuthParam): Flow<Resource<AuthDomain>>
}