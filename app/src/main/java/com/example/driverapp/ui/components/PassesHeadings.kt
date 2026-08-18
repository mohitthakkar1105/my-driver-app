package com.example.driverapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PassesHeadings(
    heading: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(18.dp)
                .width(4.dp)
                .background(
                    color = Color(0xFF8A9433),
                    shape = RoundedCornerShape(
                        10.dp
                    )
                )
        ) { }
        Spacer(
            modifier = Modifier.width(10.dp)
        )
        Text(
            text = heading,
            color = Color.Black,
            fontSize = 13.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Box(
            modifier = Modifier
                .width(60.dp)
                .height(25.dp)
                .background(
                    color = Color(0xFFF2F2F2),
                    shape = RoundedCornerShape(
                        10.dp
                    )
                )
                .border(
                    color = Color(0xFFE0E0E0),
                    width = 1.dp,
                    shape = RoundedCornerShape(
                        10.dp
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                value,
                fontSize = 12.sp,
                color = Color(0xFF1A1A1A)
            )
        }
    }
}