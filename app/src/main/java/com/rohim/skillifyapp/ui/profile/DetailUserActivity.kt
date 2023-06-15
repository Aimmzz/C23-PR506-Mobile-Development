package com.rohim.skillifyapp.ui.profile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rohim.skillifyapp.data.model.DummyData
import com.rohim.skillifyapp.databinding.ActivityDetailUserBinding
import com.rohim.skillifyapp.ui.home.ui.connection.ConnectionFragment

class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userData = intent.getParcelableExtra<DummyData>(ConnectionFragment.PARCELABLE)

        binding.apply {
            photoUserDetail.setImageResource(userData?.imageUser!!)
            fullName.text = userData.fullName
            tvCompanyDetailUser.text = userData.nameCompanyUser
            descProfileUser.text = userData.descriptionUser
            descKeahlianUser.text = userData.qualificationUser
            descPhoneUser.text = userData.phoneNumberUser
            descAlamatUser.text = userData.addressUser
            descEmailUser.text = userData.emailUser
            descWebsiteUser.text = userData.websiteUser
            descLinkedinUser.text = userData.linkedinUser
            btnLihatCvUser.setOnClickListener {
                val moveToCv = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://drive.google.com/file/d/18SBZnFI-1cA1dfZdQPQx8iAKLu60Ayem/view?usp=sharing")
                }
                startActivity(moveToCv)
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}