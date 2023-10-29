package com.arafat1419.medcheck.ui.features.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arafat1419.core.domain.model.AuthDomain
import com.arafat1419.core.domain.usecase.DataUseCase
import com.arafat1419.core.vo.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(private val dataUseCase: DataUseCase) : ViewModel() {
    private val _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()

    fun setLoginUiState(loginUiState: LoginUiState) {
        _loginUiState.value = loginUiState
    }

    fun login(onSuccess: (AuthDomain) -> Unit) {
        viewModelScope.launch {
            dataUseCase.login(loginUiState.value.authParam).collect { result ->
                when (result) {
                    is Resource.Error -> _loginUiState.update {
                        it.copy(
                            isLoading = false,
                            errorData = result.error
                        )
                    }

                    is Resource.Loading -> _loginUiState.update { it.copy(isLoading = true) }
                    is Resource.Success -> {
                        _loginUiState.update {
                            it.copy(
                                isLoading = false,
                                authDomain = result.data
                            )
                        }
                        result.data?.let { onSuccess(it) }
                    }
                }
            }
        }
    }
}