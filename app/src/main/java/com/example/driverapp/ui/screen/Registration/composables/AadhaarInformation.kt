package com.example.driverapp.ui.screen.Registration.composables
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.driverapp.ui.components.AppTextFieldLabel
import com.example.driverapp.ui.components.RegistrationTextField
import com.example.driverapp.ui.components.SelectDocumentImage
import com.example.driverapp.ui.screen.Registration.RegistrationEvent
import com.example.driverapp.ui.screen.Registration.RegistrationViewModel
import com.example.learnjetpackcompose.ImagePicker.rememberGalleryPicker

@Composable
fun AadhaarInformation() {

    val viewModel = viewModel<RegistrationViewModel>()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    val openGalleryAadhaar = rememberGalleryPicker {
        viewModel.onEvent(RegistrationEvent.onImageSelectedAadhar(it))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                state = rememberScrollState()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SelectDocumentImage(
            title = "Upload Aadhaar Card",
            subTitle = "Front & Back - number will auto-fill",
            selectLicenceImage = {
                openGalleryAadhaar()
            }
        )
        AppTextFieldLabel("Aadhaar Number")
        RegistrationTextField(
            value = uiState.aadhaarNumber,
            onChange = {
                viewModel.onEvent(
                    RegistrationEvent.onAadhaarChange(it)
                )
            },
            icon = Icons.Filled.CreditCard,
            hint = "Auto-filled after scan - or type manually"
        )
    }
}