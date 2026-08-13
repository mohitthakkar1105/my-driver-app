package com.example.driverapp.ui.screen.home

import android.net.Uri
import com.example.driverapp.ui.screen.registration.RegistrationEvent

sealed interface HomeEvent {

    data class fetchingLatLong(
        val lat: Double,
        val lng: Double
    ) : HomeEvent

    data class fetchingAddress(
        val address : String
    ) : HomeEvent

}