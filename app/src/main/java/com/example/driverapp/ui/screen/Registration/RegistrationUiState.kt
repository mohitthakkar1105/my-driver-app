package com.example.driverapp.ui.screen.login

import android.net.Uri

data class RegistrationUiState(
    val selectedImageUri : Uri? = null,
    val firstName : String = "",
    val lastName : String = "",
    val dateOfBirth : String = "",
    val selectGender : Int = -1,
    val selectedImageLicence : Uri? = null,
    val licenceNumber : String = "",
    val selectedImagePan : Uri? = null,
    val panNumber : String = "",
    val selectedImageAadhaar : Uri? = null,
    val aadhaarNumber : String = "",
    )