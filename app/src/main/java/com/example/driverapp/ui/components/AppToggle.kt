package com.example.driverapp.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppToggle(
    isOnline: Boolean,
    onToggle: () -> Unit
) {


    val thumbOffset by animateDpAsState(
        targetValue = if (isOnline) 28.dp else 0.dp,
        label = "ToggleAnimation"
    )

    Box(
        modifier = Modifier
            .height(40.dp)
            .clickable(
                indication = null,
                interactionSource = remember {
                    MutableInteractionSource()
                }
            ) {
                onToggle()
            } // parent bada
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .width(60.dp)
                .height(23.dp)
                .background(
                    if (isOnline)
                        Color(0xFF2E7D32)
                    else
                        Color.Gray.copy(alpha = 0.4f),
                    RoundedCornerShape(28.dp)
                )
        )

        Box(
            modifier = Modifier
                .size(33.dp)
                .offset(x = thumbOffset, y = (3).dp)
                .background(
                    Color.White,
                    CircleShape
                )
        )
    }
}