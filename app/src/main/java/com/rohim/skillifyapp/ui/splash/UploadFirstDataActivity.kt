package com.rohim.skillifyapp.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rohim.skillifyapp.databinding.ActivityUploadFirstDataBinding

class UploadFirstDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadFirstDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadFirstDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}