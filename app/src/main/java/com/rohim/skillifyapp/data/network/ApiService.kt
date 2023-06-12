package com.rohim.skillifyapp.data.network

import com.rohim.skillifyapp.data.request.LoginRequest
import com.rohim.skillifyapp.data.request.RegisterRequest
import com.rohim.skillifyapp.data.response.LoginResponse
import com.rohim.skillifyapp.data.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST("user/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): RegisterResponse


    @POST("user/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse
}