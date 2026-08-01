package com.example.driverapp.ui.components
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

    cornerRadius: Int = 14

) {

    Button(

        onClick = onClick,

        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),

        enabled = enabled,

        shape = RoundedCornerShape(cornerRadius.dp),

        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor,
            disabledContainerColor = backgroundColor.copy(alpha = 0.5f),
            disabledContentColor = textColor.copy(alpha = 0.5f)
        )

    ) {

        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium
        )

    }

}