package com.rohim.skillifyapp.data.network

import com.rohim.skillifyapp.data.request.LoginRequest
import com.rohim.skillifyapp.data.request.RegisterRequest
import com.rohim.skillifyapp.data.response.AddUserDataResponse
import com.rohim.skillifyapp.data.response.LoginResponse
import com.rohim.skillifyapp.data.response.RegisterResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("user/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): RegisterResponse

    @POST("user/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

    @Multipart
    @POST("user/add-user-data/{id}")
    suspend fun addUserData(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
        @Part("fullName") fullName: RequestBody,
        @Part("age") age: RequestBody,
        @Part("description") description: RequestBody,
        @Part("cv") cv: RequestBody,
        @Part("skills") skills: RequestBody,
        @Part("address") address: RequestBody,
        @Part("phoneNumber") phoneNumber: RequestBody,
        @Part("email") email: RequestBody,
        @Part("website") website: RequestBody,
        @Part("linkedin") linkedin: RequestBody
    ): AddUserDataResponse

    @GET("user/get-user-data-by-id/{id}")
    suspend fun getUserData(
        @Header("Authorization") token: String,
        @Path("id") id: String
    )

    //filename untuk multipart
    //aplication/json
}