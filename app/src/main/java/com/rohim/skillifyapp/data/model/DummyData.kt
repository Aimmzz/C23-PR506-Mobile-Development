package com.rohim.skillifyapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class DummyData(
    val imageUser: Int,
    val fullName: String,
    val nameCompanyUser: String,
    val descriptionUser: String,
    val qualificationUser: String,
    val phoneNumberUser: String,
    val addressUser: String,
    val emailUser: String,
    val websiteUser: String,
    val linkedinUser: String

) : Parcelable