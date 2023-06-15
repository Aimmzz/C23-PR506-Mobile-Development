package com.rohim.skillifyapp.ui.job

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rohim.skillifyapp.R
import com.rohim.skillifyapp.data.model.JobEntity
import com.rohim.skillifyapp.databinding.ActivityDetailJobBinding
import com.rohim.skillifyapp.ui.home.ui.home.HomeFragment

class DetailJobActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailJobBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailJobBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val jobData = intent.getParcelableExtra<JobEntity>(HomeFragment.INTENT_PARCELABLE)

        binding.apply {
            photoProfileDetail.setImageResource(jobData?.imageCompany!!)
            tvNameDetailProfile.text = jobData.jobTitle
            tvCompanyDetailProfile.text = jobData.companyName
            descAddressDetail.text = jobData.address
            descJob.text = jobData.description
            descEmailJobDetail.text = jobData.email
            descKontakhr.text = jobData.phoneNumber
            descWebsiteJob.text = jobData.website
            descLinkedinJob.text = jobData.linkedin
            descKualifikasi.text = jobData.qualifications
            btnEmailDetailJob.setOnClickListener {
                val recipientEmail = jobData.email
                val subject = "Lamaran Pekerjaan - [Nama Posisi] - [Nama Anda]"
                val body = getString(R.string.template_body)
                val moveEmail = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(recipientEmail))
                    putExtra(Intent.EXTRA_SUBJECT, subject)
                    putExtra(Intent.EXTRA_TEXT, body)
                }
                startActivity(moveEmail)
            }
            btnPhone.setOnClickListener {
                val arrayPhoneNumber = jobData.phoneNumber
                val moveToPhone = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:+62")
                }
                startActivity(moveToPhone)
            }
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}