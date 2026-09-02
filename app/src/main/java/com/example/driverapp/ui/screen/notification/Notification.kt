package com.example.driverapp.ui.screen.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.driverapp.R
import com.example.driverapp.ui.components.CustomImage
import com.example.driverapp.ui.components.NotificationCard
import com.example.driverapp.ui.navigation.AppController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Notification(
    appController: AppController
) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFB7C145),
                                Color(0xFF8A9433)
                            )
                        )
                    )
            ) {
                TopAppBar(
                    navigationIcon = {
                        Box(
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .size(38.dp)
                                .clip(CircleShape)
                                .background(Color.Black)
                                .clickable { appController.navController.popBackStack() },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    },
                    title = {
                        Column(
                            verticalArrangement = Arrangement.spacedBy((2).dp)
                        ) {
                            Text(
                                text = "Notifications",
                                color = Color.White,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.ExtraBold,
                                lineHeight = 17.sp
                            )
                            Text(
                                text = "0 total",
                                color = Color.White,
                                fontSize = 10.sp,
                                lineHeight = 10.sp
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            CustomImage(
                image = R.drawable.app_background,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 20.dp
                    )
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                NotificationCard(
                    title = "Ride Cancelled",
                    subtitle = "You cancelled the ride",
                    timeAgo = "12d ago",
                    icon = Icons.Rounded.Cancel,
                    iconColor = Color(0xFFE53935),
                    onDeleteClick = {

                    },
                )
                Spacer(modifier = Modifier.height(10.dp))
                NotificationCard(
                    title = "Ride Cancelled",
                    subtitle = "You cancelled the ride",
                    timeAgo = "7d ago",
                    icon = Icons.Rounded.Cancel,
                    iconColor = Color(0xFFE53935),
                    onDeleteClick = {

                    },
                )
                Spacer(modifier = Modifier.height(10.dp))
                NotificationCard(
                    title = "Ride Cancelled",
                    subtitle = "You cancelled the ride",
                    timeAgo = "8d ago",
                    icon = Icons.Rounded.Cancel,
                    iconColor = Color(0xFFE53935),
                    onDeleteClick = {

                    },
                )
                Spacer(modifier = Modifier.height(10.dp))
                NotificationCard(
                    title = "Ride Cancelled",
                    subtitle = "You cancelled the ride",
                    timeAgo = "10d ago",
                    icon = Icons.Rounded.Cancel,
                    iconColor = Color(0xFFE53935),
                    onDeleteClick = {

                    },
                )
            }
        }
    }
}