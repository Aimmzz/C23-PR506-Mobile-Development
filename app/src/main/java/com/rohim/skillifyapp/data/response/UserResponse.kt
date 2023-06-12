package com.rohim.skillifyapp.data.response

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("lastName")
	val lastName: String,

	@field:SerializedName("website")
	val website: String,

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("linkedIn")
	val linkedIn: String,

	@field:SerializedName("skills")
	val skills: String,

	@field:SerializedName("firstName")
	val firstName: String,

	@field:SerializedName("profilePhoto")
	val profilePhoto: String,

	@field:SerializedName("cv")
	val cv: String,

	@field:SerializedName("phoneNumber")
	val phoneNumber: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("age")
	val age: String,

	@field:SerializedName("email")
	val email: String
)