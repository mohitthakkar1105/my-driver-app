package com.example.driverapp.ui.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private val _uiEffect = MutableSharedFlow<ProfileUiEffect>()

    val uiEffect = _uiEffect.asSharedFlow()

    fun onEvent(event: ProfileEvent) {
        when (event) {
            ProfileEvent.ClickOnMyProfile -> {
                viewModelScope.launch {
                    _uiEffect.emit(
                        ProfileUiEffect.NavigateToSubProfile
                    )
                }
            }
        }
    }
}