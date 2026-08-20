package com.example.driverapp.ui.screen.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.OnTabChange -> {
                _uiState.value = _uiState.value.copy(
                    tabIndex = event.tabIndex
                )
            }

            is MainEvent.OnTabChangeTrip -> {
                _uiState.value = _uiState.value.copy(
                    tabIndexTrip = event.tabIndexTrip
                )
            }
        }
    }
}