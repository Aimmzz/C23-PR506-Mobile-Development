package com.rohim.skillifyapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rohim.skillifyapp.databinding.ActivityMainHomeBinding

class MainHomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}