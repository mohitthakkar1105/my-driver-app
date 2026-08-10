package com.example.driverapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VehicleSelectedBox(
    vehicleType: String,
    vehicleSubType: List<String>?,
    name: String,
    nameSubType: List<String>,
    selectVehicle: (String,List<String>?) -> Unit
) {
    Box(
        modifier = Modifier
            .height(80.dp)
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            .background(
                color = if (vehicleType == name) Color(0xFF1565C0)
                    .copy(
                        alpha = 0.1f
                    ) else Color.White,
                shape = RoundedCornerShape(15.dp)
            )
            .border(
                width = 1.dp,
                color = if (vehicleType == name) Color(0xFF1565C0).copy(
                    alpha = 0.6f
                ) else Color.Gray.copy(
                    alpha = 0.5f
                ),
                shape = RoundedCornerShape(15.dp)
            ).clickable(
                onClick = {
                    selectVehicle(name,nameSubType)
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name
            )
        }
    }
}