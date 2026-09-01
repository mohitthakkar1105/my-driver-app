package com.example.driverapp.ui.screen.myVehicle

import android.net.Uri

data class MyVehicleUiState(
    val vehicleNumber: String = "",
    val rcNumber: String = "",
    val insuranceNumber: String = "",
    val insuranceExpiry: String = "",
    val vehicleCapacity: String = "",
    val selectVehicleImage: Uri? = null,
    val rcDocumentImage: Uri? = null,
    val selectInsuranceDocument: Uri? = null,
)