package com.example.driverapp.ui.screen.Registration.composables
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.driverapp.ui.components.AppTextFieldLabel
import com.example.driverapp.ui.components.CustomIcon
import com.example.driverapp.ui.components.ImagePreview
import com.example.driverapp.ui.components.RegistrationTextField
import com.example.driverapp.ui.screen.Registration.RegistrationEvent
import com.example.driverapp.ui.screen.Registration.RegistrationViewModel
import com.example.driverapp.ui.theme.DriverBlack
import com.example.learnjetpackcompose.ImagePicker.rememberGalleryPicker

@Composable
fun PersonalInformation() {

    val viewModel = viewModel<RegistrationViewModel>()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val openGallery = rememberGalleryPicker(
        onImageSelected = { uri ->

            viewModel.onEvent(
                RegistrationEvent.OnImageSelected(uri)
            )
        }
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                state = rememberScrollState()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(130.dp)
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(100)
                )
                .border(
                    width = 2.dp,
                    color = DriverBlack,
                    shape = RoundedCornerShape(100)
                )
                .clickable(
                    onClick = {
                        openGallery()
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            if (uiState.selectedImageUri == null) {
                CustomIcon(
                    icon = Icons.Default.CameraAlt,
                    tint = DriverBlack,
                    size = 50
                )
            } else {
                ImagePreview(
                    imageUri = uiState.selectedImageUri,
                    modifier = Modifier.clip(CircleShape)
                )
            }
        }
        Spacer(
            modifier = Modifier.height(5.dp)
        )
        Text(
            text = "Tap to upload profile photo",
            color = Color.Gray,
            fontSize = 14.sp
        )
        Spacer(
            modifier = Modifier.height(5.dp)
        )
        AppTextFieldLabel("First Name")
        RegistrationTextField(
            value = uiState.firstName,
            onChange = {name->
                viewModel.onEvent(
                    RegistrationEvent.onNameChange(name)
                )
            },
            icon = Icons.Default.Person,
            hint = "Enter first name"
        )
        AppTextFieldLabel("Last Name")
        RegistrationTextField(
            value = uiState.lastName,
            onChange = {name->
                viewModel.onEvent(
                    RegistrationEvent.onLastChange(name)
                )
            },
            icon = Icons.Default.Person,
            hint = "Enter last name"
        )
    }
}