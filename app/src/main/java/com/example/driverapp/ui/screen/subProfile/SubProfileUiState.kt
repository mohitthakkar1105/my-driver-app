package com.example.driverapp.ui.screen.subProfile

data class SubProfileUiState(
    val firstName: String = "-",
    val lastName: String = "-",
    val phone: String = "-",
    val email: String = "-",
    val gender: String = "-",
    val personalInfo: Int = -1,

    // address
    val addressLine1: String = "-",
    val addressLine2: String = "-",
    val city: String = "-",
    val state: String = "-",
    val pinCode: String = "-",
    val address: Int = -1,

    //document
    val aadhaar: String = "-",
    val license: String = "-",
    val document: Int = -1,

    //emergency contact
    val emergencyContactName: String = "-",
    val emergencyContactEmail: String = "-",
    val emergencyContactPhone: String = "-",
    val emergencyContactHomeAddress: String = "-",
    val emergencyContact: Int = -1,
)