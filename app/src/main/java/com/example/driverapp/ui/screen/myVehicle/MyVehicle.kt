package com.example.driverapp.ui.screen.myVehicle

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.driverapp.ui.components.AppButton
import com.example.driverapp.ui.components.CustomIcon
import com.example.driverapp.ui.components.VehicleCard
import com.example.driverapp.ui.navigation.AppController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyVehicleScreen(
    appController: AppController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        CustomIcon(
                            icon = Icons.AutoMirrored.Filled.ArrowBack
                        )
                    }
                },
                title = {
                    Text(
                        text = "My Vehicles",
                        fontSize = 18.sp
                    )
                },
                actions = {
                    Box(
                        modifier = Modifier
                            .padding(
                                all = 5.dp
                            )
                            .fillMaxHeight()
                            .width(110.dp)
                    ) {
                        AppButton(
                            text = "Add",
                            icon = Icons.Default.Add,
                            onClick = {

                            },
                            cornerRadius = 10,
                            textColor = Color.Blue,
                            fontSize = 16.sp,
                            contentPadding = PaddingValues(
                                horizontal = 1.dp
                            ),
                            backgroundColor = Color.Blue.copy(
                                alpha = 0.1f
                            )
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(
                    state = rememberScrollState()
                )
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            VehicleCard()
        }
    }
}