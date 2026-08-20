package com.example.driverapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import com.example.driverapp.ui.theme.DriverBlack
import com.example.driverapp.ui.theme.DriverWhite

@Composable
fun AppButton(

    text: String,

    onClick: () -> Unit,

    modifier: Modifier = Modifier,

    backgroundColor: Color = DriverBlack,

    textColor: Color = DriverWhite,

    enabled: Boolean = true,

    cornerRadius: Int = 14,

    borderColor: Color? = null,

    borderWidth: Dp = 1.dp,

    height: Dp = 56.dp,

    icon: ImageVector? = null,

    iconSize: Int = 18,

    fontSize: TextUnit = TextUnit.Unspecified,

    fontWeight: FontWeight? = null,

    contentPadding: PaddingValues = ButtonDefaults.ContentPadding // 👈 normal default

) {

    Button(

        onClick = onClick,

        modifier = modifier
            .fillMaxWidth()
            .height(height),

        enabled = enabled,

        shape = RoundedCornerShape(cornerRadius.dp),

        border = borderColor?.let { BorderStroke(borderWidth, it) },

        contentPadding = contentPadding,

        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor,
            disabledContainerColor = backgroundColor.copy(alpha = 0.5f),
            disabledContentColor = textColor.copy(alpha = 0.5f)
        )

    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                CustomIcon(
                    icon = icon,
                    tint = if (enabled) textColor else textColor.copy(alpha = 0.5f),
                    size = iconSize
                )
                Spacer(modifier = Modifier.width(8.dp))
            }

            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                fontSize = fontSize,
                fontWeight = fontWeight
            )
        }

    }
}