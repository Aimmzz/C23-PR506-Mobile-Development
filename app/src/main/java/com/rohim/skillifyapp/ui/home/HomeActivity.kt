package com.rohim.skillifyapp.ui.home

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.rohim.skillifyapp.R
import com.rohim.skillifyapp.databinding.ActivityHomeBinding
import com.rohim.skillifyapp.ui.home.ui.profile.ProfileFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val fragmentManager = supportFragmentManager
//        val profileFragment = ProfileFragment()
//        val fragment = fragmentManager.findFragmentByTag(ProfileFragment::class.java.simpleName)
//
//        if (fragment !is ProfileFragment) {
//            Log.d("Skillfy App", "Fragment Name :" + ProfileFragment::class.java.simpleName)
//            fragmentManager
//                .beginTransaction()
//                .add(R.id.container, profileFragment, ProfileFragment::class.java.simpleName)
//                .commit()
//        }

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_home)

        navView.setupWithNavController(navController)
    }
}