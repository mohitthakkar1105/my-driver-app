package com.example.driverapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DeleteVehicleDialogBox(
    onDismiss: () -> Unit,
    onConfirmDelete: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = Color.White,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = Color(0xFFE53935),
                    modifier = Modifier.size(22.dp)
                )
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Delete Vehicle",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        },
        text = {
            Text(
                text = "Are you sure you want to delete this vehicle? This action cannot be undone.",
                fontSize = 15.sp,
                color = Color(0xFF4A4A4A)
            )
        },
        confirmButton = {
            TextButton(
                onClick = onConfirmDelete,
                colors = androidx.compose.material3.ButtonDefaults.textButtonColors(
                    containerColor = Color(0xFFE53935),
                    contentColor = Color.White
                )
            ) {
                Text("Delete", fontWeight = FontWeight.SemiBold)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel", color = Color.Gray)
            }
        }
    )
}