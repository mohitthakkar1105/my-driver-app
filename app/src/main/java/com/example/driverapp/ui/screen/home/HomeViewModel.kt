package com.example.driverapp.ui.screen.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(
        HomeUiState()
    )
    val uiState = _uiState.asStateFlow()

    fun onEvent(event : HomeEvent){
        when (event){
            is HomeEvent.fetchingLatLong -> {
                _uiState.value = _uiState.value.copy(
                    latitude = event.lat,
                    longitude = event.lng
                )

            }
            is HomeEvent.fetchingAddress -> {
                _uiState.value = _uiState.value.copy(
                    address = event.address
                )
            }
        }
    }
}