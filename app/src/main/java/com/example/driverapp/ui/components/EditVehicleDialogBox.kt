package com.example.driverapp.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.rounded.DirectionsCar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.learnjetpackcompose.ImagePicker.rememberGalleryPicker

@Composable
fun EditVehicleDialogBox(
    closeDialogBox: (Boolean) -> Unit
) {

    var vehicleNumber by remember { mutableStateOf("") }
    var rcNumber by remember { mutableStateOf("") }
    var insuranceNumber by remember { mutableStateOf("") }
    var insuranceExpiry by remember { mutableStateOf("") }
    var vehicleCapacity by remember { mutableStateOf("") }

    val chooseVehicleImage = rememberGalleryPicker(
        onImageSelected = { uri -> }
    )

    val chooseRcImage = rememberGalleryPicker(
        onImageSelected = { uri -> }
    )

    val chooseInsuranceImage = rememberGalleryPicker(
        onImageSelected = { uri -> }
    )

    Dialog(
        onDismissRequest = {
            closeDialogBox(false)
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = 30.dp,
                    horizontal = 17.dp
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFF2A3695),
                            shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                        )
                        .padding(
                            start = 20.dp,
                            end = 20.dp,
                            top = 16.dp,
                            bottom = 16.dp
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Update Vehicle",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                    Spacer(
                        modifier = Modifier.weight(1f)
                    )
                    InfoChip(
                        text = null,
                        color = Color.White,
                        icon = Icons.Default.Close,
                        iconSize = 13,
                        horizontalPadding = 10.dp,
                        verticalPadding = 10.dp,
                        backgroundAlpha = 0.2f,
                        borderAlpha = 0.0f,
                        circular = true
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
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
                        Text(
                            text = "Type",
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
                            text = "Sub Type",
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
                            val subTypes = listOf(
                                "Pickup",
                                "Tempo",
                                "Luxury",
                                "Electric Car",
                                "Bike"
                            )

                            subTypes.forEach { type ->
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
                            label = "Vehicle number",
                            contentPadding = PaddingValues(start = 0.dp),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        RegistrationTextField(
                            value = vehicleNumber,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 0.dp),
                            onChange = { newValue -> vehicleNumber = newValue },
                            icon = Icons.Rounded.DirectionsCar,
                            hint = "Enter vehicle number"
                        )

                        // RC number
                        Spacer(modifier = Modifier.height(18.dp))
                        AppTextFieldLabel(
                            label = "RC number",
                            contentPadding = PaddingValues(start = 0.dp),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        RegistrationTextField(
                            value = rcNumber,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 0.dp),
                            onChange = { newValue -> rcNumber = newValue },
                            icon = Icons.Rounded.DirectionsCar,
                            hint = "Enter RC number"
                        )

                        // Insurance number
                        Spacer(modifier = Modifier.height(18.dp))
                        AppTextFieldLabel(
                            label = "Insurance number",
                            contentPadding = PaddingValues(start = 0.dp),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        RegistrationTextField(
                            value = insuranceNumber,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 0.dp),
                            onChange = { newValue -> insuranceNumber = newValue },
                            icon = Icons.Rounded.DirectionsCar,
                            hint = "Enter insurance number"
                        )

                        // Insurance expiry
                        Spacer(modifier = Modifier.height(18.dp))
                        AppTextFieldLabel(
                            label = "Insurance expiry",
                            contentPadding = PaddingValues(start = 0.dp),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        RegistrationTextField(
                            value = insuranceExpiry,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 0.dp),
                            onChange = { newValue -> insuranceExpiry = newValue },
                            icon = Icons.Rounded.DirectionsCar,
                            hint = "Tap to select date"
                        )

                        Spacer(modifier = Modifier.height(15.dp))
                        AppTextFieldLabel(
                            label = "Update Images (optional)",
                            contentPadding = PaddingValues(start = 0.dp),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        SelectDocumentImage(
                            title = "Vehicle Photo",
                            subTitle = "Tap to replace",
                            selectLicenceImage = {
                                chooseVehicleImage()
                            },
                            horizontalPadding = 0,
                            showUploadButton = false
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        SelectDocumentImage(
                            title = "RC Document",
                            subTitle = "Tap to replace",
                            selectLicenceImage = {
                                chooseRcImage()
                            },
                            horizontalPadding = 0,
                            showUploadButton = false
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        SelectDocumentImage(
                            title = "Insurance Document",
                            subTitle = "Tap to replace",
                            selectLicenceImage = {
                                chooseInsuranceImage()
                            },
                            horizontalPadding = 0,
                            showUploadButton = false
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        AppButton(
                            text = "Update",
                            onClick = { },
                            backgroundColor = Color(0xFF2A3695),
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }
        }
    }
}