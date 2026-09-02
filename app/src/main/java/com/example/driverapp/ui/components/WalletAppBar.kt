package com.example.driverapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WalletAppBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFB7C145).copy(alpha = 0.7f)
        ),
        title = {
            Text(text = "My Wallet", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        },
        actions = {
            CustomIcon(icon = Icons.Default.Refresh, tint = Color.Gray)
        }
    )
}