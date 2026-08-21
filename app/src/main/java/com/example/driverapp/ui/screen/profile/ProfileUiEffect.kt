package com.example.driverapp.ui.screen.profile

sealed class ProfileUiEffect {
    data object NavigateToSubProfile : ProfileUiEffect()
}