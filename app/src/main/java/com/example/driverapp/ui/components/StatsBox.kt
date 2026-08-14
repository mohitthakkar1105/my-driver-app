package com.example.driverapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StatsBox(
    icon: ImageVector,
    number: Int,
    title: String,
    color: Color,
    paddingEnd: Int
) {
    Box(
        modifier = Modifier
            .width(
                120.dp
            )
            .height(
                130.dp
            )
            .padding(end = paddingEnd.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(15.dp)
            )
            .border(
                color = color.copy(
                    alpha = 0.5f
                ),
                width = 1.dp,
                shape = RoundedCornerShape(15.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(26.dp)
                    .background(
                        color = color.copy(
                            alpha = 0.2f
                        ),
                        shape = RoundedCornerShape(100),
                    )
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                CustomIcon(
                    icon = icon,
                    size = 30,
                    tint = color
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "$number",
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = title,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.W800
            )
        }
    }
}