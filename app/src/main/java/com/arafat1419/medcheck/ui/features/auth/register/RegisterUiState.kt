package com.arafat1419.medcheck.ui.features.auth.register

import com.arafat1419.core.data.network.param.AuthParam
import com.arafat1419.core.domain.model.AuthDomain
import com.arafat1419.core.vo.ErrorData

data class RegisterUiState(
    val authParam: AuthParam = AuthParam("", ""),
    val registerFields: RegisterFields = RegisterFields(),
    val isLoading: Boolean = false,
    val authDomain: AuthDomain? = null,
    val errorData: ErrorData? = null,
    val listErrorField: MutableList<Boolean> = List(7) { true }.toMutableList()
)

