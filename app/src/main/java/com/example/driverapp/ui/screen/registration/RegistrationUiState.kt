package com.example.driverapp.ui.screen.login

import android.net.Uri

data class RegistrationUiState(
    val selectedImageUri: Uri? = null,
    val firstName: String = "",
    val lastName: String = "",
    val dateOfBirth: String = "",
    val insuranceExpiry: String = "",
    val selectGender: Int = -1,
    val selectedImageLicence: Uri? = null,
    val licenceNumber: String = "",
    val selectedImagePan: Uri? = null,
    val panNumber: String = "",
    val selectedImageAadhaar: Uri? = null,
    val aadhaarNumber: String = "",
    val selectVehicle: String = "none",
    val selectVehicleSubType: List<String>? = null,
    val selectedSubType: String = "",
    val vehicleNumber: String = "",
    val rcNumber: String = "",
    val insuranceNumber: String = "",
    val capacity: String = "",
    val selectedImageVehicle: Uri? = null,
    val selectedImageRc: Uri? = null,
    val selectedImageInsurance: Uri? = null,
)