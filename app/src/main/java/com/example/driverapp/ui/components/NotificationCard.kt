package com.example.driverapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotificationCard(
    title: String,
    subtitle: String,
    timeAgo: String,
    icon: ImageVector,
    iconColor: Color,
    onDeleteClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0xFFDCE48A),
                shape = RoundedCornerShape(16.dp)
            ),
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        shadowElevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 15.dp,
                    end = 15.dp,
                    top = 15.dp,
                    bottom = 9.dp
                ),
            verticalAlignment = Alignment.Top
        ) {

            // ── Left circular icon box ──────────────
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .background(color = Color.Black, shape = CircleShape)
                    .border(width = 1.5.dp, color = iconColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                CustomIcon(
                    icon = icon,
                    tint = iconColor,
                    size = 18
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // ── Title, subtitle, time ────────────────
            Column {
                Text(
                    text = title,
                    color = Color.Black,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = subtitle,
                    color = Color(0xFF757575),
                    fontSize = 11.sp
                )
                Text(
                    text = timeAgo,
                    color = Color(0xFFBDBDBD),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // ── Dustbin ───────────────────────────────
            InfoChip(
                text = null,
                icon = Icons.Rounded.Delete,
                color = Color(0xFFE53935),
                circular = true,
                iconSize = 16,
                horizontalPadding = 8.dp,
                verticalPadding = 8.dp,
                backgroundAlpha = 0.10f,
                borderAlpha = 0f,
            )
        }
    }
}