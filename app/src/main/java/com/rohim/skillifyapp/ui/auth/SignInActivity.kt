package com.rohim.skillifyapp.ui.auth

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rohim.skillifyapp.databinding.ActivitySignInBinding
import com.rohim.skillifyapp.ui.home.HomeActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnLogin2.setOnClickListener {
            val toHome = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(toHome)
        }

        binding.tvSignup.setOnClickListener {
            val btnToRegister2 = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(btnToRegister2)
        }
    }
}