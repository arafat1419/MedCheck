package com.arafat1419.core.data.network.response

import com.google.gson.annotations.SerializedName

internal data class AuthResponse(
	@field:SerializedName("token")
	val token: String? = null
)
