package com.example.driverapp.ui.screen.subProfile


sealed interface SubProfileEvent {
    data class EditProfileInfo(
        val edit: Int
    ) : SubProfileEvent

    data class EditAddressInfo(
        val edit: Int
    ) : SubProfileEvent

    data class EditDocumentInfo(
        val edit: Int
    ) : SubProfileEvent

    data class EditEmergencyContactInfo(
        val edit: Int
    ) : SubProfileEvent

}