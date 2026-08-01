package com.example.driverapp.ui.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import com.example.driverapp.ui.theme.DriverBlack

@Composable
fun CustomIcon(

    icon: ImageVector,

    modifier: Modifier = Modifier,

    tint: Color = DriverBlack,

    size: Int = 24

) {

    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = tint,
        modifier = modifier.size(size.dp)
    )

}