package com.example.driverapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.driverapp.ui.theme.DriverBlack
import java.sql.Driver

@Composable
fun Pill(
    type : String,
    selectedType : String,
    subType : (String) -> Unit
){
    Box(
        modifier = Modifier
            .padding(start = 14.dp)
            .border(
                width = 1.dp,
                color = Color.Gray.copy(alpha = 0.5f),
                shape = RoundedCornerShape(50.dp)
            )
            .background(
                color = if(selectedType == type) DriverBlack else Color.White,
                shape = RoundedCornerShape(50.dp)
            )
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ).clickable(
                onClick = {
                    subType(type)
                }
            )
    ) {
        Text(
            text = type,
            color = if(selectedType == type) Color.White else DriverBlack,
        )
    }
}