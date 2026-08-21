package com.example.driverapp.ui.screen.profile

sealed interface ProfileEvent {
    data object ClickOnMyProfile : ProfileEvent
}