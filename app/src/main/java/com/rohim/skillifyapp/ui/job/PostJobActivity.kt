package com.rohim.skillifyapp.ui.job

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.rohim.skillifyapp.R
import com.rohim.skillifyapp.databinding.ActivityPostJobBinding
import com.rohim.skillifyapp.ui.home.HomeActivity
import com.rohim.skillifyapp.ui.home.ui.home.HomeFragment
import com.rohim.skillifyapp.utils.createCustomTempFile
import com.rohim.skillifyapp.utils.uriToFile
import java.io.File

class PostJobActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostJobBinding
    private lateinit var currentPhotoPath: String
    private lateinit var fragmentManager: FragmentManager

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS2) {
            if (!allPermissionsGranted()) {
                Toast.makeText(
                    this,
                    "Tidak mendapatkan permission.",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS2.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostJobBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this,
                REQUIRED_PERMISSIONS2,
                REQUEST_CODE_PERMISSIONS2
            )
        }

        binding.btnPostJob.setOnClickListener {
            val post = Intent(this@PostJobActivity, HomeActivity::class.java)
            startActivity(post)
            finish()
        }
        binding.btnCamera2.setOnClickListener { startTakePhoto() }
        binding.btnGaleri2.setOnClickListener { startGallery() }
    }

    private fun startGallery() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        val chooser = Intent.createChooser(intent, "Choose a Picture")
        launcherIntentGallery.launch(chooser)
    }

    private fun startTakePhoto() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.resolveActivity(packageManager)

        createCustomTempFile(application).also {
            val photoURI: Uri = FileProvider.getUriForFile(
                this@PostJobActivity,
                "com.rohim.skillifyapp",
                it
            )
            currentPhotoPath = it.absolutePath
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
            launcherIntentCamera.launch(intent)
        }
    }

    private var getFile: File? = null
    private val launcherIntentGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val selectedImg: Uri = result.data?.data as Uri
            val myFile = uriToFile(selectedImg, this@PostJobActivity)
            getFile = myFile
            binding.previewImageView2.setImageURI(selectedImg)

        }
    }
    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == RESULT_OK) {
            val myFile = File(currentPhotoPath)
            getFile = myFile

            val result = BitmapFactory.decodeFile(getFile?.path)
            binding.previewImageView2.setImageBitmap(result)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    companion object {
        const val CAMERA_X_RESULT2 = 200

        private val REQUIRED_PERMISSIONS2 = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS2 = 10
    }
}