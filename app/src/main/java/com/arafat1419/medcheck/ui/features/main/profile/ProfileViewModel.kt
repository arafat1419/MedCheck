package com.arafat1419.medcheck.ui.features.main.profile

import androidx.lifecycle.ViewModel
import com.arafat1419.core.domain.usecase.DataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel(private val dataUseCase: DataUseCase) : ViewModel() {
    private val _profileUiState = MutableStateFlow(ProfileUiState())
    val profileUiState: StateFlow<ProfileUiState> = _profileUiState.asStateFlow()

    fun setProfileUiState(profileUiState: ProfileUiState) {
        _profileUiState.value = profileUiState
    }
}