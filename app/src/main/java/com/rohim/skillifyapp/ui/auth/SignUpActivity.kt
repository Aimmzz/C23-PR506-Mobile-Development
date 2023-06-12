package com.rohim.skillifyapp.ui.auth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.rohim.skillifyapp.R
import com.rohim.skillifyapp.data.response.ApiResult
import com.rohim.skillifyapp.databinding.ActivitySignUpBinding
import com.rohim.skillifyapp.ui.viewmodel.ViewModelFactory

class SignUpActivity : AppCompatActivity() {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setupViewModel()
        setupAction()
    }

    private fun setupAction() {
        binding.tvLoginRegister.setOnClickListener{
            startActivity(Intent(this, SignInActivity::class.java))
        }
        binding.btnSignup.setOnClickListener{
            if (valid()) {
                val username = binding.edtNameRegister.text.toString()
                val password = binding.edtPasswordRegister.text.toString()
                authViewModel.userRegister(username, password).observe(this) {
                    when (it) {
                        is ApiResult.Success -> {
                            showLoading(false)
                            Toast.makeText(this, R.string.success, Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, SignInActivity::class.java))
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
    }

    private fun valid() =
        binding.edtNameRegister.error == null && binding.edtPasswordRegister.error == null && !binding.edtNameRegister.text.isNullOrEmpty() && !binding.edtPasswordRegister.text.isNullOrEmpty()

    private fun setupViewModel() {
        val factory: ViewModelFactory = ViewModelFactory.getInstance(this)
        authViewModel = ViewModelProvider(this, factory)[AuthViewModel::class.java]
    }
    private fun showLoading(isLoading: Boolean) {
        binding.progressBarRegister.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}