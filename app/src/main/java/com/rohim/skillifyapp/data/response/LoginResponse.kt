package com.rohim.skillifyapp.data.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
	@field:SerializedName("token")
	val token: String
)