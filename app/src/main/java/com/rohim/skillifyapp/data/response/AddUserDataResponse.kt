package com.rohim.skillifyapp.data.response

import com.google.gson.annotations.SerializedName

data class AddUserDataResponse(

	@field:SerializedName("skills")
	val skills: String,

	@field:SerializedName("website")
	val website: String,

	@field:SerializedName("profilePhoto")
	val profilePhoto: String,

	@field:SerializedName("cv")
	val cv: String,

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("phoneNumber")
	val phoneNumber: String,

	@field:SerializedName("fullName")
	val fullName: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("linkedIn")
	val linkedIn: String,

	@field:SerializedName("age")
	val age: String,

	@field:SerializedName("email")
	val email: String
)
