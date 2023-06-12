package com.rohim.skillifyapp.data.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
	@field:SerializedName("uuid")
	val uuid: String,
	@field:SerializedName("token")
	val token: String
)
