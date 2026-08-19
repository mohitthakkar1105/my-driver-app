package com.example.driverapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.material.icons.rounded.CardMembership
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.DirectionsCar
import androidx.compose.material.icons.rounded.Percent
import androidx.compose.material3.HorizontalDivider
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
fun AppAvailablePlanCard(
    passTitleName: String,
    passSubTitleName: String,
    price: String,
    validDays: String,
    maxRides: String,
    commissionPercent: String,
    isCommissionFree: Boolean = false,
    onBuyClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(15.dp)
            )
            .border(
                color = Color(0xFFE0E0E0),
                width = 1.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // ── Top Row: Icon + Title + Price ──────────────
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            color = Color(0xFFE0E0E0).copy(alpha = 0.7f),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .border(
                            color = Color(0xFFE0E0E0),
                            width = 1.5.dp,
                            shape = RoundedCornerShape(15.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    CustomIcon(
                        icon = Icons.Rounded.CardMembership,
                        tint = Color.Black,
                        size = 25
                    )
                }
                Spacer(modifier = Modifier.width(7.dp))
                Column {
                    Text(
                        text = passTitleName,             // 👈 dynamic
                        color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        lineHeight = 20.sp
                    )
                    Text(
                        text = passSubTitleName,           // 👈 dynamic
                        color = Color.Black.copy(alpha = 0.7f),
                        fontSize = 11.sp,
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "₹$price",                  // 👈 dynamic
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        lineHeight = 25.sp
                    )
                    Text(
                        text = "one time",
                        color = Color.Black.copy(alpha = 0.5f),
                        fontSize = 8.sp,
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color(0xFFE0E0E0)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ── Stat Chips: Days / Rides / Commission ──────
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                StatChipBox(
                    icon = Icons.Rounded.CalendarToday,
                    label = "$validDays Days",              // 👈 dynamic
                    accent = Color.Black,
                    modifier = Modifier.weight(1f)
                )
                StatChipBox(
                    icon = Icons.Rounded.DirectionsCar,
                    label = "$maxRides Rides",               // 👈 dynamic
                    accent = Color.Black,
                    modifier = Modifier.weight(1f)
                )
                StatChipBox(
                    icon = Icons.Rounded.Percent,
                    label = if (isCommissionFree) "0% Comm" else "$commissionPercent% Comm", // 👈 dynamic
                    accent = if (isCommissionFree) Color(0xFF2E7D32) else Color.Black,
                    modifier = Modifier.weight(1f)
                )
            }

            // ── Zero Commission Banner (sirf jab true ho) ──
            if (isCommissionFree) {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(
                            color = Color(0xFF2E7D32).copy(alpha = 0.1f),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .border(
                            color = Color(0xFF2E7D32),
                            width = 1.dp,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CustomIcon(
                        icon = Icons.Rounded.CheckCircle,
                        tint = Color(0xFF2E7D32),
                        size = 14
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Zero commission - keep 100% of your earnings!",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.W500,
                        color = Color(0xFF2E7D32)
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            AppButton(
                text = "Buy This Plan",
                onClick = onBuyClick,
                modifier = Modifier.height(50.dp),
            )
        }
    }
}

@Composable
fun StatChipBox(
    icon: ImageVector,
    label: String,
    accent: Color,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(
                color = Color(0xFFF2F2F2),
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                color = Color(0xFFE0E0E0),
                width = 1.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 8.dp, vertical = 7.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CustomIcon(
                icon = icon,
                tint = accent,
                size = 12
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = label,
                color = Color.Black,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
