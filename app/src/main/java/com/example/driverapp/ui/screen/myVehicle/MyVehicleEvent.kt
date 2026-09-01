package com.example.driverapp.ui.screen.myVehicle

import android.net.Uri

sealed class MyVehicleEvent {
    data class OnVehicleNumberChange(val value: String) : MyVehicleEvent()
    data class OnRcNumberChange(val value: String) : MyVehicleEvent()
    data class OnInsuranceNumberChange(val value: String) : MyVehicleEvent()
    data class OnInsuranceExpiryChange(val value: String) : MyVehicleEvent()
    data class OnVehicleCapacityChange(val value: String) : MyVehicleEvent()
    data class OnSelectVehicleImage(val value: Uri) : MyVehicleEvent()
    data class OnSelectRcImage(val value: Uri) : MyVehicleEvent()
    data class OnSelectInsuranceImage(val value: Uri) : MyVehicleEvent()
}