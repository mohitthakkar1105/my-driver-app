package com.example.driverapp.ui.screen.Registration

import androidx.lifecycle.ViewModel
import com.example.driverapp.ui.screen.login.RegistrationUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegistrationViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        RegistrationUiState()
    )

    val uiState = _uiState.asStateFlow()

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
        }
    }
}
