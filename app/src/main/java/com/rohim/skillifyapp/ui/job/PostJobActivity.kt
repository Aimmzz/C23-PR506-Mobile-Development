package com.rohim.skillifyapp.ui.job

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rohim.skillifyapp.databinding.ActivityPostJobBinding

class PostJobActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostJobBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostJobBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}