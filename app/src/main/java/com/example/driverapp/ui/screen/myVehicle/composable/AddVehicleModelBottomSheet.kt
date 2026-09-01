package com.example.driverapp.ui.screen.myVehicle.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.DirectionsCar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.driverapp.ui.components.AppButton
import com.example.driverapp.ui.components.AppTextFieldLabel
import com.example.driverapp.ui.components.InfoChip
import com.example.driverapp.ui.components.RegistrationTextField
import com.example.driverapp.ui.components.SelectDocumentImage
import com.example.driverapp.ui.screen.login.LoginViewModel
import com.example.driverapp.ui.screen.myVehicle.MyVehicleEvent
import com.example.driverapp.ui.screen.myVehicle.MyVehicleViewModel
import com.example.learnjetpackcompose.ImagePicker.rememberGalleryPicker
import kotlin.reflect.typeOf


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddVehicleModelBottomSheet(
    setShowBottomSheet: (Boolean) -> Unit
) {

    val viewModel = viewModel<MyVehicleViewModel>()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val chooseVehicleImage = rememberGalleryPicker(
        onImageSelected = { uri ->
            viewModel.onEvent(
                MyVehicleEvent.OnSelectVehicleImage(uri)
            )
        }
    )

    val chooseRcImage = rememberGalleryPicker(
        onImageSelected = { uri ->
            viewModel.onEvent(
                MyVehicleEvent.OnSelectRcImage(uri)
            )
        }
    )

    val chooseInsuranceImage = rememberGalleryPicker(
        onImageSelected = { uri ->
            viewModel.onEvent(
                MyVehicleEvent.OnSelectInsuranceImage(uri)
            )
        }
    )

    ModalBottomSheet(
        onDismissRequest = {
            setShowBottomSheet(false)
        },
        containerColor = Color.White,
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 15.dp
                    )
            ) {
                Text(
                    text = "Add New vehicle",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                InfoChip(
                    text = null,
                    color = Color.Gray,
                    icon = Icons.Default.Close,
                    iconSize = 13,
                    horizontalPadding = 10.dp,
                    verticalPadding = 10.dp,
                    backgroundAlpha = 0.1f,
                    borderAlpha = 0.0f,
                    circular = true
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(),
                thickness = 0.51.dp,
                color = Color(0xFFE0E0E0)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(
                            state = rememberScrollState()
                        )
                        .padding(
                            horizontal = 20.dp,
                        )
                        .imePadding()
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Type*",
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        val vehicleTypes = listOf(
                            "maruti suzuki swift",
                            "tata altroz",
                            "hyundai i20",
                            "honda city",
                            "bmw 7 series",
                            "car",
                            "auto",
                        )

                        vehicleTypes.forEach { type ->
                            InfoChip(
                                text = type,
                                color = Color.Black,
                                fontSize = 14.sp,
                                horizontalPadding = 16.dp,
                                verticalPadding = 8.dp,
                                cornerRadius = 30.dp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Sub Type*",
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        val vehicleTypes = listOf(
                            "Pickup",
                            "Tempo",
                            "Luxury",
                            "Electric Car",
                            "Bike"
                        )

                        vehicleTypes.forEach { type ->
                            InfoChip(
                                text = type,
                                color = Color.Black,
                                fontSize = 14.sp,
                                horizontalPadding = 16.dp,
                                verticalPadding = 8.dp,
                                cornerRadius = 30.dp
                            )
                        }
                    }

                    // Vehicle number
                    Spacer(modifier = Modifier.height(18.dp))
                    AppTextFieldLabel(
                        label = "Vehicle number*",
                        contentPadding = PaddingValues(
                            start = 0.dp
                        ),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    RegistrationTextField(
                        value = uiState.vehicleNumber,
                        modifier = Modifier.padding(horizontal = 0.dp),
                        onChange = { newValue ->
                            viewModel.onEvent(MyVehicleEvent.OnVehicleNumberChange(newValue))
                        },
                        icon = Icons.Rounded.DirectionsCar,
                        hint = "Auto-filled after scan - or type manually"
                    )

                    // RC number
                    Spacer(modifier = Modifier.height(18.dp))
                    AppTextFieldLabel(
                        label = "RC number*",
                        contentPadding = PaddingValues(
                            start = 0.dp
                        ),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    RegistrationTextField(
                        value = uiState.rcNumber,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 0.dp),
                        onChange = { newValue ->
                            viewModel.onEvent(MyVehicleEvent.OnRcNumberChange(newValue))
                        },
                        icon = Icons.Rounded.DirectionsCar,
                        hint = "Enter RC number - or type manually"
                    )

                    // Insurance number
                    Spacer(modifier = Modifier.height(18.dp))
                    AppTextFieldLabel(
                        label = "Insurance number*",
                        contentPadding = PaddingValues(
                            start = 0.dp
                        ),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    RegistrationTextField(
                        value = uiState.insuranceNumber,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 0.dp),
                        onChange = { newValue ->
                            viewModel.onEvent(MyVehicleEvent.OnInsuranceNumberChange(newValue))
                        },
                        icon = Icons.Rounded.DirectionsCar,
                        hint = "Enter insurance number - or type manually"
                    )

                    // Insurance expiry
                    Spacer(modifier = Modifier.height(18.dp))
                    AppTextFieldLabel(
                        label = "Insurance expiry*",
                        contentPadding = PaddingValues(
                            start = 0.dp
                        ),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    RegistrationTextField(
                        value = uiState.insuranceExpiry,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 0.dp),
                        onChange = { newValue ->
                            viewModel.onEvent(MyVehicleEvent.OnInsuranceExpiryChange(newValue))
                        },
                        icon = Icons.Rounded.DirectionsCar,
                        hint = "Tap to select date"
                    )

                    // Vehicle capacity
                    Spacer(modifier = Modifier.height(18.dp))
                    AppTextFieldLabel(
                        label = "Vehicle capacity*",
                        contentPadding = PaddingValues(
                            start = 0.dp
                        ),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    RegistrationTextField(
                        value = uiState.vehicleCapacity,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 0.dp),
                        onChange = { newValue ->
                            viewModel.onEvent(MyVehicleEvent.OnVehicleCapacityChange(newValue))
                        },
                        icon = Icons.Rounded.DirectionsCar,
                        hint = "e.g. 4 seater / 1000 kg"
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    AppTextFieldLabel(
                        label = "Upload Documents*",
                        contentPadding = PaddingValues(
                            start = 0.dp
                        ),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    SelectDocumentImage(
                        title = "Vehicle Photo",
                        subTitle = "Tap to upload",
                        selectLicenceImage = {
                            chooseVehicleImage()
                        },
                        horizontalPadding = 0
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    SelectDocumentImage(
                        title = "RC Document",
                        subTitle = "Tap to upload",
                        selectLicenceImage = {
                            chooseRcImage()
                        },
                        horizontalPadding = 0
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    SelectDocumentImage(
                        title = "Insurance Document",
                        subTitle = "Tap to upload",
                        selectLicenceImage = {
                            chooseInsuranceImage()
                        },
                        horizontalPadding = 0
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    AppButton(
                        text = "Add Vehicle",
                        onClick = {

                        },
                        backgroundColor = Color(0xFF2A3695),
                    )
                }
            }
        }
    }
}