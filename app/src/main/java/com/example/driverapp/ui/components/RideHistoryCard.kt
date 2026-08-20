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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ReportProblem
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material.icons.rounded.ElectricRickshaw
import androidx.compose.material.icons.rounded.Straighten
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RideHistoryCard(
    vehicleType: String = "Auto",
    vehicleNumber: String = "3",
    driverName: String = "Aaditya",
    price: String = "100",
    date: String = "20 Aug 25 • 10:30 am",
    pickupLocation: String = "Connaught Place, New Delhi",
    dropLocation: String = "IGI Airport, Terminal 3",
    status: String = "Completed",
    timeTaken: String = "18 min",
    km: String = "12.4 km",
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
                color = Color.Black.copy(
                    alpha = 0.1f
                ),
                width = 0.5.dp,
                shape = RoundedCornerShape(15.dp)
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        15.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            color = Color(0xFFE0E0E0).copy(alpha = 0.2f),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .border(
                            color = Color(0xFFE0E0E0),
                            width = 1.dp,
                            shape = RoundedCornerShape(10.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    CustomIcon(
                        icon = Icons.Rounded.ElectricRickshaw,
                        tint = Color.Black,
                        size = 25
                    )
                }
                Spacer(modifier = Modifier.width(7.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        text = "$vehicleType • $vehicleNumber Seater",
                        color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        lineHeight = 13.sp,
                        style = LocalTextStyle.current.copy(
                            lineHeightStyle = LineHeightStyle(
                                alignment = LineHeightStyle.Alignment.Center,
                                trim = LineHeightStyle.Trim.Both
                            )
                        )
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomIcon(
                            icon = Icons.Outlined.Person,
                            tint = Color.Gray,
                            size = 11
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = driverName,
                            color = Color.Gray,
                            fontSize = 11.sp,
                            lineHeight = 11.sp,
                            style = LocalTextStyle.current.copy(
                                lineHeightStyle = LineHeightStyle(
                                    alignment = LineHeightStyle.Alignment.Center,
                                    trim = LineHeightStyle.Trim.Both
                                )
                            )
                        )
                    }
                    Text(
                        text = date,
                        color = Color.Gray.copy(alpha = 0.6f),
                        fontSize = 10.sp,
                        lineHeight = 10.sp,
                        style = LocalTextStyle.current.copy(
                            lineHeightStyle = LineHeightStyle(
                                alignment = LineHeightStyle.Alignment.Center,
                                trim = LineHeightStyle.Trim.Both
                            )
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "₹$price",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 0.7.dp,
                color = Color(0xFFE0E0E0)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(all = 15.dp)
            ) {
                RoutePoint(
                    color = Color(0xFFFFD700),
                    label = pickupLocation,
                    tag = "FROM"
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    DottedLine(
                        height = 20.dp,
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
                RoutePoint(
                    color = Color.Red,
                    label = dropLocation,
                    tag = "TO"
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 15.dp)
            ) {
                InfoChip(
                    icon = Icons.Rounded.Straighten,
                    text = km,
                    color = Color.Gray,
                    verticalPadding = 1.dp
                )
                Spacer(modifier = Modifier.width(8.dp))
                InfoChip(
                    icon = Icons.Rounded.AccessTime,
                    text = timeTaken,
                    color = Color.Gray,
                    verticalPadding = 1.dp
                )
                Spacer(modifier = Modifier.width(8.dp))
                InfoChip(
                    icon = null,
                    text = status,
                    color = Color.Gray,
                    verticalPadding = 1.dp,
                    cornerRadius = 20.dp
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                modifier = Modifier.padding(horizontal = 15.dp)
            ) {
                AppButton(
                    text = "Log Complaint",
                    onClick = { },
                    borderColor = Color(0xFFB7C145),
                    borderWidth = 1.4.dp,
                    backgroundColor = Color(0xFFB7C145).copy(
                        alpha = 0.1f
                    ),
                    textColor = Color(0xFFB7C145),
                    icon = Icons.Outlined.ReportProblem,
                    height = 50.dp,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

@Composable
private fun RoutePoint(
    color: Color,
    label: String,
    tag: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(
                    color = color,
                    shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column() {
            Text(
                text = tag,
                color = Color.Gray,
                fontSize = 9.sp,
                lineHeight = 9.sp,
                style = LocalTextStyle.current.copy(
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.Both
                    )
                )
            )
            Text(
                text = label,
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 12.sp,
                style = LocalTextStyle.current.copy(
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.Both
                    )
                )
            )
        }
    }
}

