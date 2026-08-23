package com.example.driverapp.ui.screen.subProfile


sealed interface SubProfileEvent {
    data class EditProfileInfo(
        val edit : Int
    ) : SubProfileEvent
}