package com.example.driverapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DottedLine(
    modifier: Modifier = Modifier,
    color: Color = Color.LightGray,
    height: Dp = 30.dp,
    strokeWidth: Dp = 2.dp
) {
    Canvas(
        modifier = modifier
            .width(strokeWidth)
            .height(height)
    ) {
        drawLine(
            color = color,
            start = Offset(size.width / 2, 0f),
            end = Offset(size.width / 2, size.height),
            strokeWidth = strokeWidth.toPx(),
            pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(10f, 10f), // dash length, gap length
                0f
            ),
            cap = StrokeCap.Round
        )
    }
}