package com.example.driverapp.ui.screen.login

sealed interface LoginEvent {

    data object TickCheck : LoginEvent

    data object SendOtp : LoginEvent

}