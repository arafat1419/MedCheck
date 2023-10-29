package com.arafat1419.medcheck.ui.features.auth.register

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

class RegisterViewModel(private val dataUseCase: DataUseCase) : ViewModel() {
    private val _registerUiState = MutableStateFlow(RegisterUiState())
    val registerUiState: StateFlow<RegisterUiState> = _registerUiState.asStateFlow()

    fun setRegisterUiState(registerUiState: RegisterUiState) {
        _registerUiState.value = registerUiState
    }

    fun register(onSuccess: (AuthDomain) -> Unit) {
        viewModelScope.launch {
            dataUseCase.register(registerUiState.value.authParam).collect { result ->
                when (result) {
                    is Resource.Error -> _registerUiState.update {
                        it.copy(
                            isLoading = false,
                            errorData = result.error
                        )
                    }

                    is Resource.Loading -> _registerUiState.update { it.copy(isLoading = true) }
                    is Resource.Success -> {
                        _registerUiState.update {
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