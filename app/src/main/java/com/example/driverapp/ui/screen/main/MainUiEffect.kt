package com.example.driverapp.ui.screen.main

sealed class MainUiEffect {

    data object NavigateToProfile : MainUiEffect()

    data object NavigateToNotification : MainUiEffect()
}