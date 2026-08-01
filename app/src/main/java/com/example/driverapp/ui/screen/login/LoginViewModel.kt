package com.example.driverapp.ui.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(
        LoginUiState()
    )

    val uiState = _uiState.asStateFlow()

    private val _uiEffect = MutableSharedFlow<LoginUiEffect>()

    val uiEffect = _uiEffect.asSharedFlow()

    fun onEvent(event : LoginEvent){
        when (event){
            LoginEvent.TickCheck -> {
                _uiState.update {
                    it.copy(
                        isChecked = !_uiState.value.isChecked
                    )
                }
            }
            LoginEvent.SendOtp -> {
                viewModelScope.launch {
                    _uiEffect.emit(
                        LoginUiEffect.NavigateToOtp
                    )
                }
            }
        }
    }
}