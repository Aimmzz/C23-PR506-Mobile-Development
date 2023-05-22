package com.rohim.skillifyapp.ui.auth

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.rohim.skillifyapp.R
import com.rohim.skillifyapp.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.tvSignup.setOnClickListener {
            val btnToRegister2 = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(btnToRegister2)
        }
    }
}