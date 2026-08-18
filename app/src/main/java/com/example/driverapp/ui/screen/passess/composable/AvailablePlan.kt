package com.example.driverapp.ui.screen.passess.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocalOffer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.driverapp.ui.components.CustomIcon
import com.example.driverapp.ui.components.PassesHeadings

@Composable
fun AvailablePlan() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.Transparent
            )
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(185.dp)
                    .background(
                        color = Color.Black,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(25.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Box(
                            modifier = Modifier
                                .width(
                                    120.dp
                                )
                                .height(25.dp)
                                .background(
                                    color = Color.White.copy(
                                        alpha = 0.2f
                                    ),
                                    shape = RoundedCornerShape(
                                        40.dp
                                    )
                                )
                                .border(
                                    color = Color.White.copy(
                                        alpha = 0.3f
                                    ),
                                    width = 0.5.dp,
                                    shape = RoundedCornerShape(
                                        40.dp
                                    )
                                ),
                            contentAlignment = androidx.compose.ui.Alignment.Center
                        ) {
                            Text(
                                text = "EXCLUSIVE PLANS",
                                fontSize = 10.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )
                        Text(
                            text = "Ride More,\nPay Less",
                            fontSize = 23.sp,
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Spacer(
                            modifier = Modifier.height(12.dp)
                        )
                        Text(
                            text = "Zero commission plans for more\nearning every ride",
                            fontSize = 12.sp,
                            color = Color.White.copy(
                                alpha = 0.7f
                            ),
                            lineHeight = 16.sp,
                            fontWeight = FontWeight.W400
                        )
                    }
                    Spacer(
                        modifier = Modifier.width(40.dp)
                    )
                    Box(
                        modifier = Modifier
                            .height(70.dp)
                            .width(70.dp)
                            .background(
                                color = Color.White.copy(
                                    alpha = 0.2f
                                ),
                                shape = RoundedCornerShape(
                                    100.dp
                                )
                            )
                            .border(
                                color = Color.White.copy(
                                    alpha = 0.3f
                                ),
                                width = 0.5.dp,
                                shape = RoundedCornerShape(
                                    40.dp
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        CustomIcon(
                            icon = Icons.Rounded.LocalOffer,
                            tint = Color.White,
                            size = 30
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(17.dp))
            PassesHeadings(
                heading = "Available Plans",
                value = "9 Plans"
            )
        }
    }
}