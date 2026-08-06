package com.example.driverapp.ui.screen.Registration

import androidx.lifecycle.ViewModel
import com.example.driverapp.ui.screen.login.LoginUiState
import com.example.driverapp.ui.screen.login.RegistrationUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegistrationViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        RegistrationUiState()
    )

    val uiState = _uiState.asStateFlow()

    fun onEvent(event: RegistrationEvent){
        when(event) {

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
        }
    }
}