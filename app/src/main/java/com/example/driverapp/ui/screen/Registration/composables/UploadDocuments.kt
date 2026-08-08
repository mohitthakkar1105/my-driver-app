package com.example.driverapp.ui.screen.Registration.composables
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.driverapp.ui.components.AppTextFieldLabel
import com.example.driverapp.ui.components.CustomIcon
import com.example.driverapp.ui.components.RegistrationTextField
import com.example.driverapp.ui.components.SelectDocumentImage
import com.example.driverapp.ui.screen.Registration.RegistrationEvent
import com.example.driverapp.ui.screen.Registration.RegistrationViewModel
import com.example.learnjetpackcompose.ImagePicker.rememberGalleryPicker

@Composable
fun UploadDocuments() {

    val viewModel = viewModel<RegistrationViewModel>()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    val openGalleryLicence = rememberGalleryPicker { uri ->
        viewModel.onEvent(
            RegistrationEvent.OnImageSelectedLicence(uri)
        )
    }

    val openGalleryPan = rememberGalleryPicker {
        viewModel.onEvent(
            RegistrationEvent.onImageSelectedPan(it)
        )
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
            title = "Driving Licence",
            subTitle = "Front & Back - number will auto-fill",
            selectLicenceImage = {
                openGalleryLicence()
            }
        )
        AppTextFieldLabel("Licence Number")
        RegistrationTextField(
            value = uiState.licenceNumber,
            onChange = {
                viewModel.onEvent(
                    RegistrationEvent.onLicenceChange(it)
                )
            },
            icon = Icons.Default.Book,
            hint = "Auto-filled after scan - or type manually"
        )
        AppTextFieldLabel("Pan Details", fontWeight = FontWeight.W700, fontSize = 17.sp)
        SelectDocumentImage(
            title = "Pan Card",
            subTitle = "Upload PAN - number will auto-fill",
            selectLicenceImage = {
                openGalleryPan()
            }
        )
        AppTextFieldLabel("Pan Number")
        RegistrationTextField(
            value = uiState.panNumber,
            onChange = {
                viewModel.onEvent(
                    RegistrationEvent.onPanChange(it)
                )
            },
            icon = Icons.Default.Wallet,
            hint = "Auto-filled after scan - or type manually"
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    20.dp
                )
                .background(
                    color = Color(0xFF1565C0)
                        .copy(
                            alpha = 0.1f
                        ),
                    shape = RoundedCornerShape(15.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color(0xFF1565C0).copy(
                        alpha = 0.6f
                    ),
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "If the Scanned number wasn't detected correctly, you can manually edit it in the field above.Your verification will be based on your name and date of birth.",
                    fontSize = 13.sp,
                    color = Color(0xFF1565C0)
                )
            }
        }
    }
}