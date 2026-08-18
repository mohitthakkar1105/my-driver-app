package com.example.driverapp.ui.screen.main

sealed interface MainEvent {
    data class OnTabChange(
        val tabIndex: Int
    ) : MainEvent

}
