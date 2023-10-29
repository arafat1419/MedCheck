package com.arafat1419.medcheck.ui.features.auth.login

import com.arafat1419.core.data.network.param.AuthParam
import com.arafat1419.core.domain.model.AuthDomain
import com.arafat1419.core.vo.ErrorData

data class LoginUiState(
    val authParam: AuthParam = AuthParam("", ""),
    val isLoading: Boolean = false,
    val authDomain: AuthDomain? = null,
    val errorData: ErrorData? = null,
    val listErrorField: MutableList<Boolean> = List(2) { true }.toMutableList()
)
