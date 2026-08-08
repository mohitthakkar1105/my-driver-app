package com.example.driverapp.ui.screen.Registration

import android.net.Uri

sealed interface RegistrationEvent {

    data class OnImageSelected(
        val uri: Uri
    ) : RegistrationEvent

    data class onNameChange(
        val name: String
    ) : RegistrationEvent

    data class onLastChange(
        val name: String
    ) : RegistrationEvent

    data class onDateChange(
        val date: String
    ) : RegistrationEvent

    data class onGenderChange(
        val gender: Int
    ) : RegistrationEvent

    data class OnImageSelectedLicence(
        val uri: Uri
    ) : RegistrationEvent

    data class onLicenceChange(
        val licence: String
    ) : RegistrationEvent

    data class  onImageSelectedPan(
        val uri : Uri
    ) : RegistrationEvent

    data class onPanChange(
        val pan: String
    ) : RegistrationEvent

    data class  onImageSelectedAadhar(
        val uri : Uri
    ) : RegistrationEvent

    data class onAadhaarChange(
        val aadhaar: String
    ) : RegistrationEvent
}