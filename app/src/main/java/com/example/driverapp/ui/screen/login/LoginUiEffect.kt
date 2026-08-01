package com.example.driverapp.ui.screen.login

sealed class LoginUiEffect{

    data object NavigateToOtp : LoginUiEffect()
}