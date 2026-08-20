package com.example.driverapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.TripOrigin
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ActiveRideCard(
    rideId: String = "2730",
    price: String = "100.44",
    pickupAddress: String = "64, Mari Mata Square, Indore, Madhya Pradesh, India",
    dropAddress: String = "44, Bartan Bazar, Indore, Madhya Pradesh",
    driverName: String = "Rahul Sharma",
    phoneNumber: String = "98765 43210",
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(15.dp)
            )
            .border(
                color = Color.Red,
                width = 0.5.dp,
                shape = RoundedCornerShape(15.dp)
            )
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            color = Color.Red.copy(alpha = 0.1f),
                            shape = CircleShape,
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    CustomIcon(
                        icon = Icons.Default.Lock,
                        tint = Color.Red,
                        size = 20
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomIcon(
                            icon = Icons.Default.Key,
                            tint = Color(0xFFFFD700),
                            size = 18,
                            modifier = Modifier.rotate(120f)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "OTP Verification Pending",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red.copy(alpha = 0.8f),
                            lineHeight = 14.sp,
                            style = TextStyle(
                                lineHeightStyle = LineHeightStyle(
                                    alignment = LineHeightStyle.Alignment.Center,
                                    trim = LineHeightStyle.Trim.Both
                                )
                            )
                        )
                    }
                    Text(
                        text = "Ride #$rideId • ₹$price",
                        fontSize = 11.sp,
                        color = Color.Black.copy(alpha = 0.5f),
                        lineHeight = 11.sp,
                        style = TextStyle(
                            lineHeightStyle = LineHeightStyle(
                                alignment = LineHeightStyle.Alignment.Center,
                                trim = LineHeightStyle.Trim.Both
                            )
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                AppButton(
                    text = "Go to Ride",
                    onClick = { },
                    backgroundColor = Color.Red,
                    textColor = Color.White,
                    fontSize = 13.sp,
                    cornerRadius = 40,
                    height = 30.dp,
                    contentPadding = PaddingValues(
                        horizontal = 16.dp,
                        vertical = 0.dp
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 0.5.dp,
                color = Color(0xFFE0E0E0)
            )
            Spacer(modifier = Modifier.height(10.dp))

            // ── Pickup ──────────────────────────
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomIcon(
                    icon = Icons.Default.TripOrigin,
                    tint = Color(0xFFFFD700),
                    size = 12
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = pickupAddress,
                    fontSize = 12.sp,
                    color = Color.Black,
                    maxLines = 1,
                    lineHeight = 14.sp,
                    style = TextStyle(
                        lineHeightStyle = LineHeightStyle(
                            alignment = LineHeightStyle.Alignment.Center,
                            trim = LineHeightStyle.Trim.Both
                        )
                    )
                )
            }
            Spacer(modifier = Modifier.height(4.dp))

            // ── Dropoff ─────────────────────────
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomIcon(
                    icon = Icons.Default.LocationOn,
                    tint = Color.Red,
                    size = 12
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = dropAddress,
                    fontSize = 12.sp,
                    color = Color.Black,
                    maxLines = 1,
                    lineHeight = 14.sp,
                    style = TextStyle(
                        lineHeightStyle = LineHeightStyle(
                            alignment = LineHeightStyle.Alignment.Center,
                            trim = LineHeightStyle.Trim.Both
                        )
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            // ── Passenger ────────────────────────
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomIcon(
                    icon = Icons.Default.Person,
                    tint = Color.Black.copy(alpha = 0.4f),
                    size = 12
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = driverName,
                    fontSize = 11.sp,
                    color = Color.Black.copy(alpha = 0.6f)
                )
                Spacer(modifier = Modifier.width(10.dp))
                CustomIcon(
                    icon = Icons.Default.Phone,
                    tint = Color.Black.copy(alpha = 0.4f),
                    size = 11
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = phoneNumber,
                    fontSize = 11.sp,
                    color = Color.Black.copy(alpha = 0.6f)
                )
            }
        }
    }
}