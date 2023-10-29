package com.arafat1419.medcheck.ui.features.auth.register

data class RegisterFields(
    val firstName: String = "",
    val lastName: String = "",
    val identityNumber: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)