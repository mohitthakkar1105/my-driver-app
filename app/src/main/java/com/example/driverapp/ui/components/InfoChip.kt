package com.example.driverapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoChip(
    text: String?,
    color: Color,
    icon: ImageVector? = null,
    iconSize: Int = 11,
    fontSize: TextUnit = 10.sp,
    cornerRadius: Dp = 8.dp,
    horizontalPadding: Dp = 8.dp,
    verticalPadding: Dp = 4.dp,
    backgroundAlpha: Float = 0.07f,
    borderAlpha: Float = 0.2f,
    circular: Boolean = false
) {
    val shape = if (circular) {
        CircleShape
    } else {
        RoundedCornerShape(cornerRadius)
    }

    Row(
        modifier = Modifier
            .background(
                color = color.copy(alpha = backgroundAlpha),
                shape = shape
            )
            .border(
                color = color.copy(alpha = borderAlpha),
                width = 1.dp,
                shape = shape
            )
            .padding(
                horizontal = horizontalPadding,
                vertical = verticalPadding
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon != null) {
            CustomIcon(
                icon = icon,
                tint = color,
                size = iconSize
            )

            if (text != null) {
                Spacer(
                    modifier = Modifier.width(3.dp)
                )
            }
        }

        if (text != null) {
            Text(
                text = text,
                color = color,
                fontSize = fontSize,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}