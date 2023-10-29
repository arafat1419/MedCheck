package com.arafat1419.medcheck.ui.features.main.profile

data class ProfileUiState(
    val profileFields: ProfileFields = ProfileFields(),
    val listErrorField: MutableList<Boolean> = List(5) { true }.toMutableList()
)

