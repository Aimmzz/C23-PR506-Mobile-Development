package com.rohim.skillifyapp.ui.auth

import android.content.Context
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.rohim.skillifyapp.R
import com.rohim.skillifyapp.data.SkillipyPreferences
import com.rohim.skillifyapp.data.model.UserEntity
import com.rohim.skillifyapp.data.response.ApiResult
import com.rohim.skillifyapp.data.response.LoginResponse
import com.rohim.skillifyapp.databinding.ActivitySignInBinding
import com.rohim.skillifyapp.ui.home.HomeActivity
import com.rohim.skillifyapp.ui.home.ui.home.HomeFragment
import com.rohim.skillifyapp.ui.viewmodel.ViewModelFactory

class SignInActivity : AppCompatActivity() {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")
    private lateinit var binding: ActivitySignInBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setupViewModel()
        setupAction()
    }
    private fun setupAction() {
        binding.btnLogin2.setOnClickListener {
            if (valid()) {
                val username = binding.edtNameLogin.text.toString()
                val password = binding.edtPasswordLogin.text.toString()
                authViewModel.userLogin(username, password).observe(this) {
                    when (it) {
                        is ApiResult.Success -> {
                            showLoading(false)
                            val response = it.data
                            saveUserData(
                                UserEntity(
                                    response.token,
//                                    response.loginResult?.token.toString(),
                                    true
                                )
                            )
                            Toast.makeText(this, R.string.success1, Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, HomeActivity::class.java))
                            finishAffinity()
                        }
                        is ApiResult.Loading -> showLoading(true)
                        is ApiResult.Error -> {
                            Toast.makeText(this, it.error, Toast.LENGTH_SHORT).show()
                            showLoading(false)
                        }
                    }
                }
            } else {
                Toast.makeText(
                    this,
                    resources.getString(R.string.check_input),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.tvSignup.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }


    private fun saveUserData(userEntity: UserEntity) {
        authViewModel.saveUser(userEntity)
    }

    private fun setupViewModel() {
        val factory: ViewModelFactory = ViewModelFactory.getInstance(this)
        authViewModel = ViewModelProvider(this, factory)[AuthViewModel::class.java]
    }
    private fun valid() =
        binding.edtNameLogin.error == null && binding.edtPasswordLogin.error == null && !binding.edtNameLogin.text.isNullOrEmpty() && !binding.edtPasswordLogin.text.isNullOrEmpty()
    private fun showLoading(isLoading: Boolean) {
        binding.progressBarLogin.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}