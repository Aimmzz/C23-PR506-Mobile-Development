package com.rohim.skillifyapp.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.rohim.skillifyapp.data.model.User
import com.rohim.skillifyapp.data.model.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SkillipyPreferences private constructor(private val dataStore: DataStore<Preferences>) {

    fun getUserData(): Flow<User> {
        return dataStore.data.map { preferences ->
            User(
                preferences[TOKEN] ?: "",
                preferences[ID] ?: ""
            )
        }
    }

    suspend fun saveUserData(userEntity: UserEntity) {
        dataStore.edit { preferences ->
            preferences[TOKEN] = userEntity.token
            preferences[STATE] = userEntity.isLogin
        }
    }

    suspend fun login() {
        dataStore.edit { preferences ->
            preferences[STATE] = true
        }
    }

    suspend fun logout() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: SkillipyPreferences? = null

        private val TOKEN = stringPreferencesKey("token")
        private val STATE = booleanPreferencesKey("state")
        private val ID = stringPreferencesKey("id")

        fun getInstance(dataStore: DataStore<Preferences>): SkillipyPreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = SkillipyPreferences(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}