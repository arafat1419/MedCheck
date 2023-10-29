package com.arafat1419.core.utils

import com.arafat1419.core.data.network.response.AuthResponse
import com.arafat1419.core.domain.model.AuthDomain

internal object DataMapper {
    fun AuthResponse.toDomain(): AuthDomain = AuthDomain(token)
}