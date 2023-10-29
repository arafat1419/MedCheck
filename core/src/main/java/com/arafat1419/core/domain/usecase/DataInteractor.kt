package com.arafat1419.core.domain.usecase

import com.arafat1419.core.data.network.param.AuthParam
import com.arafat1419.core.domain.model.AuthDomain
import com.arafat1419.core.domain.repository.DataRepository
import com.arafat1419.core.vo.Resource
import kotlinx.coroutines.flow.Flow

internal class DataInteractor(private val dataRepository: DataRepository): DataUseCase {
    override fun login(param: AuthParam): Flow<Resource<AuthDomain>> =
        dataRepository.login(param)

    override fun register(param: AuthParam): Flow<Resource<AuthDomain>> =
        dataRepository.register(param)
}