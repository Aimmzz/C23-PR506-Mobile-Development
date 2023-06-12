package com.rohim.skillifyapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.rohim.skillifyapp.data.SkillipyPreferences
import com.rohim.skillifyapp.data.SkillipyRepository
import com.rohim.skillifyapp.data.network.ApiConfig


val Context.dataStore: DataStore<Preferences> by preferencesDataStore("skillipyapp")
object SkillifyInjection {
    fun provideRepository(context: Context): SkillipyRepository {
        val preferences = SkillipyPreferences.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        return SkillipyRepository.getInstance(preferences, apiService)
    }
}