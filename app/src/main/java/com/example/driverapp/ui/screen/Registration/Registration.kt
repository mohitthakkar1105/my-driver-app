package com.example.driverapp.ui.screen.Registration

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.example.driverapp.ui.components.CustomIcon
import com.example.driverapp.ui.navigation.AppController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registration(
    appController: AppController
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                           text = "Registration",
                            fontSize = 20.sp
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        CustomIcon(
                            icon = Icons.AutoMirrored.Filled.ArrowBack
                        )
                    }
                }
            )
        }
    ) {

    }
}