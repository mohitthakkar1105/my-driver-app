package com.example.driverapp.ui.screen.Registration.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.driverapp.ui.components.AppTextFieldLabel

@Composable
fun VehicleInformation() {

    val vehicles = mapOf<String, List<String>>(
        "sedan" to listOf("Ac", "Non Ac"),
        "suv" to listOf("Ac", "Non Ac"),
        "hatchback" to listOf("Ac", "Non Ac"),
        "bike" to listOf("Standard"),
        "auto" to listOf("Standard"),
        "mini truck" to listOf("Open", "Closed")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                state = rememberScrollState()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppTextFieldLabel("Select vehicle type", fontSize = 17.sp, fontWeight = FontWeight.W600)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(vehicles.keys.toList()) { type ->

            }
        }
    }
}