package com.example.driverapp.ui.screen.subProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SubProfileViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SubProfileUiState())

    val uiState = _uiState.asStateFlow()

    private val _uiEffect = MutableSharedFlow<SubProfileUiEffect>()

    val uiEffect = _uiEffect.asSharedFlow()

    fun onEvent(event: SubProfileEvent) {
        when (event) {
            is SubProfileEvent.EditProfileInfo -> {
                _uiState.value = _uiState.value.copy(
                    personalInfo = event.edit
                )
            }

            is SubProfileEvent.EditAddressInfo -> {
                _uiState.value = _uiState.value.copy(
                    address = event.edit
                )
            }

            is SubProfileEvent.EditDocumentInfo -> {
                _uiState.value = _uiState.value.copy(
                    document = event.edit
                )
            }

            is SubProfileEvent.EditEmergencyContactInfo -> {
                _uiState.value = _uiState.value.copy(
                    emergencyContact = event.edit
                )
            }

            SubProfileEvent.ClickToMyVehicle -> {
                viewModelScope.launch {
                    _uiEffect.emit(
                        SubProfileUiEffect.NavigateToMyVehicle
                    )
                }
            }
        }
    }
}
