package com.rohim.skillifyapp.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rohim.skillifyapp.data.SkillipyRepository
import com.rohim.skillifyapp.di.SkillifyInjection
import com.rohim.skillifyapp.ui.auth.AuthViewModel

class ViewModelFactory(private val repository: SkillipyRepository):
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            return AuthViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.simpleName)
    }
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory {
            return instance ?: synchronized(this) {
                instance ?: ViewModelFactory(SkillifyInjection.provideRepository(context))
            }.also { instance = it }
        }
    }
}