package com.example.driverapp.ui.screen.main

sealed interface MainEvent {
    data class OnTabChange(
        val tabIndex: Int
    ) : MainEvent

    data class OnTabChangeTrip(
        val tabIndexTrip: Int
    ) : MainEvent

    data object OnProfileClick : MainEvent
}
