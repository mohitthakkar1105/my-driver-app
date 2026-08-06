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
}