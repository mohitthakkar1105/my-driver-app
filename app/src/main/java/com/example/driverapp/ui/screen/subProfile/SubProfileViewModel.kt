package com.example.driverapp.ui.screen.subProfile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SubProfileViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SubProfileUiState())

    val uiState = _uiState.asStateFlow()

    fun onEvent(event: SubProfileEvent) {
        when (event) {
            is SubProfileEvent.EditProfileInfo -> {
                _uiState.value = _uiState.value.copy(
                    personalInfo = event.edit
                )
            }
        }
    }
}
