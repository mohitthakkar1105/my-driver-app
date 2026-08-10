package com.example.driverapp.ui.screen.registration.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Chair
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.driverapp.ui.components.Pill
import com.example.driverapp.ui.components.RegistrationTextField
import com.example.driverapp.ui.components.SelectDocumentImage
import com.example.driverapp.ui.components.VehicleSelectedBox
import com.example.driverapp.ui.screen.registration.RegistrationEvent
import com.example.driverapp.ui.screen.registration.RegistrationViewModel
import com.example.driverapp.ui.theme.DriverBlack
import com.example.learnjetpackcompose.ImagePicker.rememberGalleryPicker
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VehicleInformation() {

    val viewModel = viewModel<RegistrationViewModel>()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val openGalleryVehicle = rememberGalleryPicker { uri ->
        viewModel.onEvent(
            RegistrationEvent.onImageSelectedVehicle(uri)
        )
    }

    var showDatePickerDialog by remember() {
        mutableStateOf(false)
    }

    val openGalleryRc = rememberGalleryPicker {uri->
        viewModel.onEvent(
            RegistrationEvent.onImageSelectedRc(uri)
        )
    }

    val openGalleryInsurance = rememberGalleryPicker {uri->
        viewModel.onEvent(
            RegistrationEvent.onImageSelectedInsurance(uri)
        )
    }

    val vehicles = mapOf(
        "sedan" to listOf("Ac", "Non Ac"),
        "suv" to listOf("Ac", "Non Ac"),
        "hatchback" to listOf("Ac", "Non Ac"),
        "bike" to listOf("Standard"),
        "auto" to listOf("Standard"),
        "mini truck" to listOf("Open", "Closed")
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            AppTextFieldLabel("Select vehicle type", fontWeight = FontWeight.W600)
        }

        // Grid items
        items(vehicles.entries.toList()) { vehicle ->
            VehicleSelectedBox(
                name = vehicle.key,
                vehicleType = uiState.selectVehicle,
                nameSubType = vehicle.value,
                selectVehicle = { vehicle, vehicleSubType ->

                    viewModel.onEvent(
                        RegistrationEvent.onSelectingVehicle(
                            Vehicle = vehicle,
                            VehicleSubType = vehicleSubType
                        )
                    )
                },
                vehicleSubType = uiState.selectVehicleSubType
            )
        }

        if (uiState.selectVehicleSubType != null) {
            item(
                span = { GridItemSpan(maxLineSpan) }
            ) {
                AppTextFieldLabel("Select vehicle sub type", fontWeight = FontWeight.W600)
            }
        }

        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {

            Row {

                uiState.selectVehicleSubType?.forEach { type ->

                    Pill(
                        type = type,
                        selectedType = uiState.selectedSubType,
                        subType = {
                            viewModel.onEvent(
                                RegistrationEvent.onSelectingVehicleSubType(it)
                            )
                        }
                    )
                }
            }
        }
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            AppTextFieldLabel("Vehicle number", fontWeight = FontWeight.W600)
        }
        item(
            span = {
                GridItemSpan(currentLineSpan = maxLineSpan)
            }
        ) {
            RegistrationTextField(
                value = uiState.vehicleNumber,
                onChange = {
                    viewModel.onEvent(
                        RegistrationEvent.onChangeVehicleNumber(it)
                    )
                },
                icon = Icons.Filled.DirectionsCar,
                hint = "Auto-filled after scan - or type manually"
            )
        }
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            AppTextFieldLabel("RC number", fontWeight = FontWeight.W600)
        }
        item(
            span = {
                GridItemSpan(currentLineSpan = maxLineSpan)
            }
        ) {
            RegistrationTextField(
                value = uiState.rcNumber,
                onChange = {
                    viewModel.onEvent(
                        RegistrationEvent.onChangeRcNumber(it)
                    )
                },
                icon = Icons.Filled.Article,
                hint = "Auto-filled after scan - or type manually"
            )
        }
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            AppTextFieldLabel("Insurance number", fontWeight = FontWeight.W600)
        }
        item(
            span = {
                GridItemSpan(currentLineSpan = maxLineSpan)
            }
        ) {
            RegistrationTextField(
                value = uiState.insuranceNumber,
                onChange = {
                    viewModel.onEvent(
                        RegistrationEvent.onChangeInsuranceNumber(it)
                    )
                },
                icon = Icons.Filled.Security,
                hint = "Auto-filled after scan - or type manually"
            )
        }
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            AppTextFieldLabel("Insurance expiry date", fontWeight = FontWeight.W600)
        }
        item (
            span = { GridItemSpan(maxLineSpan) }
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        56.dp
                    )
                    .clickable(
                        onClick = {
                            showDatePickerDialog = true
                        }
                    )
                    .padding(
                        horizontal = 20.dp
                    )
                    .background(
                        color = Color.Gray.copy(
                            alpha = 0.1f
                        ),
                        shape = RoundedCornerShape(10.dp),
                    )
                    .border(
                        width = 1.dp,
                        color = DriverBlack,
                        shape = RoundedCornerShape(10.dp),
                    ),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 18.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CustomIcon(
                        icon = Icons.Default.CalendarMonth,
                        tint = DriverBlack,
                    )
                    Spacer(
                        modifier = Modifier.width(
                            3.dp
                        )
                    )
                    Text(
                        text = uiState.insuranceExpiry.ifEmpty {
                            "DD-MM-YYYY"
                        },
                        color = DriverBlack.copy(
                            alpha = 0.7f
                        ),
                        fontSize = 16.sp
                    )
                }
            }
        }
        item (
            span = { GridItemSpan(maxLineSpan) }
        ){
            if(showDatePickerDialog){
                val datePickerState = rememberDatePickerState()
                DatePickerDialog(
                    onDismissRequest = {
                        showDatePickerDialog = false
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                datePickerState.selectedDateMillis?.let { millis ->
                                    val formattedDate = SimpleDateFormat(
                                        "dd/MM/yyyy",
                                        Locale.getDefault()
                                    ).format(
                                        Date(millis)
                                    )
                                    viewModel.onEvent(
                                        RegistrationEvent.onInsuranceExpiry(formattedDate)
                                    )
                                }
                                showDatePickerDialog = false
                            }
                        ) {
                            Text(
                                text = "ok"
                            )
                        }
                    },
                ){
                    DatePicker(
                        state = datePickerState
                    )
                }
            }
        }
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            AppTextFieldLabel("Vehicle capacity", fontWeight = FontWeight.W600)
        }
        item(
            span = {
                GridItemSpan(currentLineSpan = maxLineSpan)
            }
        ) {
            RegistrationTextField(
                value = uiState.capacity,
                onChange = {
                    viewModel.onEvent(
                        RegistrationEvent.onChangeCapacityNumber(it)
                    )
                },
                icon = Icons.Default.Chair,
                hint = "e.g. 4 seats"
            )
        }
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            AppTextFieldLabel("Vehicle documents", fontWeight = FontWeight.W800, fontSize = 20.sp)
        }
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            SelectDocumentImage(
                title = "Vehicle photo",
                subTitle = "Clear front or side photo",
                selectLicenceImage = {
                    openGalleryVehicle()
                }
            )
        }
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Spacer(modifier = Modifier.height(10.dp))
        }
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            SelectDocumentImage(
                title = "RC document",
                subTitle = "Front and back",
                selectLicenceImage = {
                    openGalleryRc()
                }
            )
        }
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Spacer(modifier = Modifier.height(10.dp))
        }
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            SelectDocumentImage(
                title = "Insurance document",
                subTitle = "Insurance copy",
                selectLicenceImage = {
                    openGalleryInsurance()
                }
            )
        }
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}