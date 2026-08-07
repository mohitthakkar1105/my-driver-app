package com.example.driverapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun RegistrationTextField(
    value: String,
    onChange: (String) -> Unit,
    icon: ImageVector,
    hint: String,
    readOnly: Boolean = false,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)
        .background(
            color = Color.Gray.copy(
                alpha = 0.1f
            ),
            shape = RoundedCornerShape(10.dp),
        ),
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            onChange(it)
        },
        readOnly = readOnly,
        shape = RoundedCornerShape(10.dp),
        prefix = {
            CustomIcon(
                icon
            )
        },
        placeholder = {
            Text(
                text = hint
            )
        },
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black,
        ),
    )
}