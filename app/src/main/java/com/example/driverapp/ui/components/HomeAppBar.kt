package com.example.driverapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.driverapp.R

@Composable
fun HomeAppBar(
    address: String,
    goToProfile : ()-> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFB7C145).copy(alpha = 0.7f)
            )
            .statusBarsPadding()
            .padding(15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(
                        50.dp
                    )
                    .clip(CircleShape)
                    .border(
                        color = Color(0xFFB7C145),
                        width = 2.dp,
                        shape = RoundedCornerShape(100.dp)
                    )
                    .clickable(
                        onClick = {
                            goToProfile()
                        }
                    )
            ) {
                CustomImage(
                    R.drawable.default_logo,
                    contentScale = ContentScale.Crop,
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = "Mohit Thakkar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CustomIcon(
                        Icons.Default.LocationOn,
                        tint = Color.Red,
                        size = 15
                    )
                    Text(
                        text = if (address.isEmpty()) "Location Unavailable" else address,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 12.sp,
                        color = Color.Black.copy(
                            alpha = 0.6f
                        ),
                        fontWeight = FontWeight.W600
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                CustomIcon(
                    Icons.Default.NotificationsNone,
                    tint = Color.Black,
                    size = 22
                )
                Box(
                    modifier = Modifier
                        .size(25.dp)
                        .align(Alignment.TopEnd)
                        .offset(
                            x = 6.dp,
                            y = (-6).dp
                        )
                        .background(
                            color = Color.Red,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "99+",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }
            }
        }
    }
}