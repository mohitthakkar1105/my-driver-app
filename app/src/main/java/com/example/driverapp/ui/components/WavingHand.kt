package com.example.driverapp.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.sp

@Composable
fun WavingHand() {

    val infiniteTransition =
        rememberInfiniteTransition(
            label = ""
        )

    val rotation by infiniteTransition.animateFloat(
        initialValue = -15f,
        targetValue = 15f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 400
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )

    Text(
        text = "👋",
        fontSize = 42.sp,
        modifier = Modifier.rotate(rotation)
    )
}