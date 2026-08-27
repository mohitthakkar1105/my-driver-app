package com.example.driverapp.ui.screen.otp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class OtpViewModel : ViewModel(){

    private val _uiEffect = MutableSharedFlow<OtpUiEffect>()

    val uiEffect = _uiEffect.asSharedFlow()



    fun onEvent(event : OtpEvent){
        when(event){
            OtpEvent.OnVerifyOtp -> {
                viewModelScope.launch {
                    _uiEffect.emit(
                        OtpUiEffect.NavigateToRegistration
                    )
                }
            }
        }
    }
}