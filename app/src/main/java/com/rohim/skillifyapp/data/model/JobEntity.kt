package com.rohim.skillifyapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class JobEntity(
    val imageCompany: Int,
    val jobTitle: String,
    val companyName: String,
    val address: String,
    val description: String,
    val qualifications: String,
    val phoneNumber: String,
    val email: String,
    val website: String,
    val linkedin: String
) : Parcelable