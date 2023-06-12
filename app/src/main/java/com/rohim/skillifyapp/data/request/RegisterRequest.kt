package com.rohim.skillifyapp.data.request

import com.google.gson.annotations.SerializedName

data class RegisterRequest(

	@field:SerializedName("username")
	val username: String,

	@field:SerializedName("password")
	val password: String,
)
