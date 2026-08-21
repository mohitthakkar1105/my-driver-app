package com.example.driverapp.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())

    val uiState = _uiState.asStateFlow()

    private val _uiEffect = MutableSharedFlow<MainUiEffect>()

    val uiEffect = _uiEffect.asSharedFlow()

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

            MainEvent.OnProfileClick -> {
                viewModelScope.launch {
                    _uiEffect.emit(
                        MainUiEffect.NavigateToProfile
                    )
                }
            }
        }
    }
}