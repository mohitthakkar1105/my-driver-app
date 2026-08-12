package com.example.driverapp.ui.screen.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.driverapp.ui.screen.login.RegistrationUiState
import com.example.driverapp.ui.screen.otp.OtpUiEffect
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistrationViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        RegistrationUiState()
    )

    val uiState = _uiState.asStateFlow()

    private val _uiEffect = MutableSharedFlow<RegistrationUiEffect>()

    val uiEffect = _uiEffect.asSharedFlow()

    fun onEvent(event: RegistrationEvent) {
        when (event) {

            is RegistrationEvent.OnImageSelected -> {

                _uiState.update {
                    it.copy(
                        selectedImageUri = event.uri
                    )
                }
            }

            is RegistrationEvent.onNameChange -> {
                _uiState.update {
                    it.copy(
                        firstName = event.name
                    )
                }
            }

            is RegistrationEvent.onLastChange -> {
                _uiState.update {
                    it.copy(
                        lastName = event.name
                    )
                }
            }

            is RegistrationEvent.onDateChange -> {
                _uiState.update {
                    it.copy(
                        dateOfBirth = event.date
                    )
                }
            }

            is RegistrationEvent.onGenderChange -> {
                _uiState.update {
                    it.copy(
                        selectGender = event.gender
                    )
                }
            }

            is RegistrationEvent.OnImageSelectedLicence -> {
                _uiState.update {
                    it.copy(
                        selectedImageLicence = event.uri
                    )
                }
            }

            is RegistrationEvent.onLicenceChange -> {
                _uiState.update {
                    it.copy(
                        licenceNumber = event.licence
                    )
                }
            }

            is RegistrationEvent.onImageSelectedPan -> {
                _uiState.update {
                    it.copy(
                        selectedImagePan = event.uri
                    )
                }
            }

            is RegistrationEvent.onPanChange -> {
                _uiState.update {
                    it.copy(
                        panNumber = event.pan
                    )
                }
            }
            is RegistrationEvent.onImageSelectedAadhar -> {
                _uiState.update {
                    it.copy(
                        selectedImageAadhaar = event.uri
                    )
                }
            }
            is RegistrationEvent.onAadhaarChange -> {
                _uiState.update {
                    it.copy(
                        aadhaarNumber = event.aadhaar
                    )
                }
            }

            is RegistrationEvent.onSelectingVehicle -> {
                _uiState.update {
                    it.copy(
                        selectVehicle = event.Vehicle,
                        selectVehicleSubType = event.VehicleSubType
                    )
                }
            }
            is RegistrationEvent.onSelectingVehicleSubType -> {
                _uiState.update {
                    it.copy(
                        selectedSubType = event.CurrentVehicleSubType
                    )
                }
            }
            is RegistrationEvent.onChangeVehicleNumber -> {
                _uiState.update {
                    it.copy(
                        vehicleNumber = event.vehicleNumber
                    )
                }
            }
            is RegistrationEvent.onChangeRcNumber -> {
                _uiState.update {
                    it.copy(
                        rcNumber = event.rcNumber
                    )
                }
            }
            is RegistrationEvent.onChangeInsuranceNumber -> {
                _uiState.update {
                    it.copy(
                        insuranceNumber = event.insuranceNumber
                    )
                }
            }
            is RegistrationEvent.onChangeCapacityNumber -> {
                _uiState.update {
                    it.copy(
                        capacity = event.capacity
                    )
                }
            }
            is RegistrationEvent.onImageSelectedVehicle -> {
                _uiState.update {
                    it.copy(
                        selectedImageVehicle = event.uri
                    )
                }
            }
            is RegistrationEvent.onImageSelectedRc -> {
                _uiState.update {
                    it.copy(
                        selectedImageRc = event.uri
                    )
                }
            }
            is RegistrationEvent.onImageSelectedInsurance -> {
                _uiState.update {
                    it.copy(
                        selectedImageInsurance = event.uri
                    )
                }
            }
            is RegistrationEvent.onInsuranceExpiry -> {
                _uiState.update {
                    it.copy(
                        insuranceExpiry = event.expiry
                    )
                }
            }
            RegistrationEvent.OnSubmittingRegistration -> {
                viewModelScope.launch {
                    _uiEffect.emit(
                        RegistrationUiEffect.NavigateToHome
                    )
                }
            }
        }
    }
}
