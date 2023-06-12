package com.rohim.skillifyapp.ui.job

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rohim.skillifyapp.databinding.ActivityDetailJobBinding

class DetailJobActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailJobBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailJobBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}