package com.example.driverapp.ui.screen.Otp

sealed interface OtpEvent {
    data object OnVerifyOtp : OtpEvent
}