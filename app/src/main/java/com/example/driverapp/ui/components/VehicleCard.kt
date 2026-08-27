package com.example.driverapp.ui.components

import com.example.driverapp.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VehicleCard() {
    Box(
        modifier = Modifier
            .padding(
                horizontal = 15.dp
            )
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(25.dp)
            )
            .border(
                width = 1.dp,
                color = Color(0xFF2A3695),
                shape = RoundedCornerShape(25.dp)
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        color = Color(0xFF2A3695),
                        shape = RoundedCornerShape(
                            topStart = 25.dp,
                            topEnd = 25.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    )
                    .padding(
                        horizontal = 15.dp,
                        vertical = 10.dp
                    )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CustomIcon(
                        icon = Icons.Filled.CheckCircle,
                        size = 20,
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Currently Active Vehicle",
                        color = Color.White,
                        fontSize = 14.sp,
                        maxLines = 1,
                    )
                }
            }
            CustomImage(
                image = R.drawable.app_background,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Mp09075445",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                InfoChip(
                    text = "Verified",
                    color = Color.Green,
                    cornerRadius = 100.dp,
                    borderAlpha = 0.8f,
                    horizontalPadding = 10.dp,
                    fontSize = 12.sp,
                    icon = Icons.Rounded.Verified,
                    iconSize = 13
                )
                Spacer(modifier = Modifier.width(10.dp))

                // Edit button
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(100))
                        .background(Color(0xFF2196F3).copy(alpha = 0.1f))
                        .clickable {
                            // TODO: edit action
                        },
                    contentAlignment = Alignment.Center
                ) {
                    CustomIcon(
                        icon = Icons.Outlined.Edit,
                        tint = Color(0xFF2196F3),
                        size = 16
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))

                // Delete button
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(100))
                        .background(Color(0xFFF44336).copy(alpha = 0.1f))
                        .clickable {
                            // TODO: delete action
                        },
                    contentAlignment = Alignment.Center
                ) {
                    CustomIcon(
                        icon = Icons.Outlined.Delete,
                        tint = Color(0xFFF44336),
                        size = 16
                    )
                }
            }
            Text(
                text = "Auto - 3 seaters",
                fontSize = 14.sp,
                color = Color(0xFF2A3695),
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(
                    horizontal = 20.dp
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 15.dp
                    ),
                thickness = 0.51.dp,
                color = Color(0xFFE0E0E0)
            )
            Spacer(modifier = Modifier.height(10.dp))
            VehicleCardSubInfo(
                key = "Type",
                value = "Auto"
            )
            Spacer(modifier = Modifier.height(4.dp))
            VehicleCardSubInfo(
                key = "Sub Type",
                value = "3 Seaters"
            )
            Spacer(modifier = Modifier.height(4.dp))
            VehicleCardSubInfo(
                key = "RC Number",
                value = "hdhs"
            )
            Spacer(modifier = Modifier.height(4.dp))
            VehicleCardSubInfo(
                key = "Insurance No.",
                value = "hxhx"
            )
            Spacer(modifier = Modifier.height(4.dp))
            VehicleCardSubInfo(
                key = "Insurance Exp.",
                value = "30/06/2026"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Documents",
                fontSize = 15.sp,
                color = Color.Black,
                fontWeight = FontWeight.W600,
                modifier = Modifier.padding(
                    horizontal = 20.dp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp
                    ),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // RC Document
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "RC Document",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFF5F6FA))
                            .border(
                                width = 1.dp,
                                color = Color(0xFFE0E0E0),
                                shape = RoundedCornerShape(10.dp)
                            )
                    ) {
                        CustomImage(
                            image = R.drawable.app_background,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                // Insurance Document
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Insurance Document",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFF5F6FA))
                            .border(
                                width = 1.dp,
                                color = Color(0xFFE0E0E0),
                                shape = RoundedCornerShape(10.dp)
                            )
                    ) {
                        CustomImage(
                            image = R.drawable.app_background,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}


@Composable
fun VehicleCardSubInfo(
    key: String,
    value: String
) {
    Box(
        modifier = Modifier
            .padding(
                horizontal = 20.dp
            )
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row {
            Text(
                text = key,
                fontSize = 13.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(
                modifier = Modifier.weight(0.5f)
            )
            Text(
                text = value,
                fontSize = 13.sp,
                color = Color.Black,
                fontWeight = FontWeight.Black
            )
        }
    }
}