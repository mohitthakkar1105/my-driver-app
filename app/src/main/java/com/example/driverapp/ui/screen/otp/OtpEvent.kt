package com.example.driverapp.ui.screen.otp

sealed interface OtpEvent {
    data object OnVerifyOtp : OtpEvent
}