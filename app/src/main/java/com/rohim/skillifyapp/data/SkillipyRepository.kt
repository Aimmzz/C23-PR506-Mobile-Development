package com.rohim.skillifyapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.rohim.skillifyapp.data.model.UserEntity
import com.rohim.skillifyapp.data.network.ApiService
import com.rohim.skillifyapp.data.request.LoginRequest
import com.rohim.skillifyapp.data.request.RegisterRequest
import com.rohim.skillifyapp.data.response.ApiResult
import com.rohim.skillifyapp.data.response.LoginResponse
import com.rohim.skillifyapp.data.response.RegisterResponse

class SkillipyRepository(private val preferences: SkillipyPreferences, private val apiService: ApiService) {

    fun userLogin(username: String, password: String): LiveData<ApiResult<LoginResponse>> = liveData {
        emit(ApiResult.Loading)
        try {
            val response = apiService.login(LoginRequest(username, password))
            emit(ApiResult.Success(response))
        } catch (e: Exception) {
            Log.d("Login", e.message.toString())
            emit(ApiResult.Error(e.message.toString()))
        }
    }
    fun userRegister(username: String, password: String): LiveData<ApiResult<RegisterResponse>> = liveData {
        emit(ApiResult.Loading)
        try {
            val response = apiService.register(
                RegisterRequest(username,  password)
            )
            emit(ApiResult.Success(response))
        } catch (e: Exception) {
            Log.d("Signup", e.message.toString())
            emit(ApiResult.Error(e.message.toString()))
        }
    }
    suspend fun saveUserData(userEntity: UserEntity) {
        preferences.saveUserData(userEntity)
    }
    suspend fun login() {
        preferences.login()
    }

    suspend fun logout() {
        preferences.logout()
    }

    companion object {
        @Volatile
        private var instance: SkillipyRepository? = null
        fun getInstance(
            preferences: SkillipyPreferences,
            apiService: ApiService
        ): SkillipyRepository =
            instance ?: synchronized(this) {
                instance ?: SkillipyRepository(preferences, apiService)
            }.also { instance = it }
    }
}
