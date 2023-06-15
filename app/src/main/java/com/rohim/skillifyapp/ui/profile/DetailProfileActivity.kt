package com.rohim.skillifyapp.ui.profile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rohim.skillifyapp.databinding.ActivityDetailProfileBinding

class DetailProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEdtProfile.setOnClickListener {
            val edtProfile = Intent(this@DetailProfileActivity, EditProfileActivity::class.java)
            startActivity(edtProfile)
        }
        binding.btnLihatCv.setOnClickListener {
            val moveToCv = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://drive.google.com/file/d/18SBZnFI-1cA1dfZdQPQx8iAKLu60Ayem/view?usp=sharing")
            }
            startActivity(moveToCv)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}