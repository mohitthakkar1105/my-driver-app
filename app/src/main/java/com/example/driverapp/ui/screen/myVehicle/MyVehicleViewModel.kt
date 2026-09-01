package com.example.driverapp.ui.screen.myVehicle

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyVehicleViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        MyVehicleUiState()
    )

    val uiState = _uiState.asStateFlow()

    fun onEvent(event: MyVehicleEvent) {
        when (event) {
            is MyVehicleEvent.OnVehicleNumberChange -> {
                _uiState.value = _uiState.value.copy(vehicleNumber = event.value)
            }

            is MyVehicleEvent.OnRcNumberChange -> {
                _uiState.value = _uiState.value.copy(rcNumber = event.value)
            }

            is MyVehicleEvent.OnInsuranceNumberChange -> {
                _uiState.value = _uiState.value.copy(insuranceNumber = event.value)
            }

            is MyVehicleEvent.OnInsuranceExpiryChange -> {
                _uiState.value = _uiState.value.copy(insuranceExpiry = event.value)
            }

            is MyVehicleEvent.OnVehicleCapacityChange -> {
                _uiState.value = _uiState.value.copy(vehicleCapacity = event.value)
            }

            is MyVehicleEvent.OnSelectVehicleImage -> {
                _uiState.value = _uiState.value.copy(selectVehicleImage = event.value)
            }

            is MyVehicleEvent.OnSelectRcImage -> {
                _uiState.value = _uiState.value.copy(rcDocumentImage = event.value)
            }

            is MyVehicleEvent.OnSelectInsuranceImage -> {
                _uiState.value = _uiState.value.copy(selectInsuranceDocument = event.value)
            }
        }
    }
}