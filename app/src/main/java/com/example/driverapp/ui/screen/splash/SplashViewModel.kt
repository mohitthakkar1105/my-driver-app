package com.example.driverapp.ui.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel(){

    private val _uiEffect = MutableSharedFlow<SplashUiEffect>()

    val uiEffect =_uiEffect.asSharedFlow()

    init {
        viewModelScope.launch {
            delay(3000)

            _uiEffect.emit(
                SplashUiEffect.NavigateToLogin
            )
        }
    }
}