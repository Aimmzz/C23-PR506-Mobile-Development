package com.rohim.skillifyapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rohim.skillifyapp.R
import com.rohim.skillifyapp.databinding.ActivityFirstPageBinding
import com.rohim.skillifyapp.ui.auth.SignInActivity
import com.rohim.skillifyapp.ui.auth.SignUpActivity

class FirstPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnGetStarted.setOnClickListener {
            val btnToRegister = Intent(this@FirstPageActivity, SignUpActivity::class.java)
            startActivity(btnToRegister)
        }
        binding.btnLogin1.setOnClickListener {
            val btnToLogin1 = Intent(this@FirstPageActivity, SignInActivity::class.java)
            startActivity(btnToLogin1)
        }
    }
}