package com.rohim.skillifyapp.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohim.skillifyapp.data.SkillipyRepository
import com.rohim.skillifyapp.data.model.UserEntity
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: SkillipyRepository): ViewModel() {
    fun login() {
        viewModelScope.launch {
            repository.login()
        }
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }

    fun saveUser(userEntity: UserEntity) {
        viewModelScope.launch {
            repository.saveUserData(userEntity)
        }
    }
    fun userLogin(username: String, password: String) = repository.userLogin(username, password)

    fun userRegister(username: String, password: String) =
        repository.userRegister(username, password)
}