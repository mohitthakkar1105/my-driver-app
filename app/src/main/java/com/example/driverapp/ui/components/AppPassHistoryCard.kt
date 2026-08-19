package com.example.driverapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.material.icons.rounded.CardMembership
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.material.icons.rounded.Receipt
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppPassHistoryCard(
    planName: String = "Daily Saver",
    status: String = "Expired",
    priceLabel: String = "₹29",
    startDate: String = "16 Jun 2026",
    expiryDate: String = "17 Jun 2026",
    purchasedOn: String = "16 Jun 2026"
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
                width = 1.dp,
                color = Color(0xFFE0E0E0),
                shape = RoundedCornerShape(15.dp)
            )
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
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
                            color = Color(0xFFB7C145).copy(alpha = 0.2f),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .border(
                            color = Color(0xFFB7C145).copy(
                                alpha = 0.8f
                            ),
                            width = 1.dp,
                            shape = RoundedCornerShape(15.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    CustomIcon(
                        icon = Icons.Rounded.CardMembership,
                        tint = Color(0xFFB7C145),
                        size = 25
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = planName,
                        color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        lineHeight = 20.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Box(
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                            .background(
                                color = Color(0xFFE0E0E0).copy(alpha = 0.3f),
                                shape = RoundedCornerShape(5.dp)
                            )
                            .border(
                                color = Color(0xFFE0E0E0).copy(alpha = 0.6f),
                                width = 1.dp,
                                shape = RoundedCornerShape(5.dp)
                            )
                            .padding(
                                horizontal = 12.dp
                            )
                    ) {
                        Text(
                            text = status,
                            color = Color.Black.copy(alpha = 0.7f),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = priceLabel,
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        lineHeight = 25.sp
                    )
                    Text(
                        text = "paid",
                        color = Color.Black.copy(alpha = 0.5f),
                        fontSize = 12.sp,
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color(0xFFE0E0E0)
            )
            Spacer(modifier = Modifier.height(15.dp))

            // Start -> Expires row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    8.dp
                )
            ) {
                DateInfoContainer(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Rounded.PlayCircle,
                    iconTint = Color(0xFF3B82F6),
                    label = "Start",
                    date = startDate
                )

                Text(
                    text = "→",
                    color = Color.Black.copy(alpha = 0.4f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                DateInfoContainer(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Rounded.CalendarToday,
                    iconTint = Color.Black.copy(alpha = 0.6f),
                    label = "Expires",
                    date = expiryDate
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Purchased on row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomIcon(
                    icon = Icons.Rounded.Receipt,
                    tint = Color.Black.copy(alpha = 0.5f),
                    size = 14
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Purchased on $purchasedOn",
                    color = Color.Black.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }
        }
    }
}


@Composable
private fun DateInfoContainer(
    modifier: Modifier = Modifier,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconTint: Color,
    label: String,
    date: String
) {
    Box(
        modifier = modifier
            .wrapContentHeight()
            .background(
                color = Color(0xFFF5F5F5),
                shape = RoundedCornerShape(12.dp)
            ).border(
                color = Color(0xFFE0E0E0),
                width = 1.dp,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 12.dp, vertical = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            CustomIcon(
                icon = icon,
                tint = iconTint,
                size = 16
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = label,
                    color = iconTint,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 16.sp
                )
                Text(
                    text = date,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 18.sp
                )
            }
        }
    }
}