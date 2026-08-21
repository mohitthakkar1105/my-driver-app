package com.example.driverapp.ui.screen.profile

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.material.icons.outlined.DeleteForever
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ReportProblem
import androidx.compose.material.icons.outlined.SwapHoriz
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.driverapp.R
import com.example.driverapp.ui.components.AppButton
import com.example.driverapp.ui.components.CustomIcon
import com.example.driverapp.ui.components.CustomImage
import com.example.driverapp.ui.components.ProfileMenuItem
import com.example.driverapp.ui.navigation.AppController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(
    appController: AppController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Box(
                        modifier = Modifier.padding(
                            horizontal = 15.dp
                        )
                    ) {
                        CustomIcon(
                            icon = Icons.AutoMirrored.Filled.ArrowBack
                        )
                    }
                },
                title = {
                    Text(
                        text = "Profile",
                        fontSize = 20.sp
                    )
                }
            )
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
                    .fillMaxWidth()
                    .padding(
                        horizontal = 15.dp,
                    )
                    .verticalScroll(
                        state = rememberScrollState(),
                    )
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .border(
                            color = Color.Gray.copy(alpha = 0.2f),
                            width = 1.dp,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .padding(
                            horizontal = 10.dp,
                            vertical = 7.dp
                        )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Profile image
                        Box(
                            modifier = Modifier
                                .size(75.dp)
                                .clip(CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            CustomImage(
                                image = R.drawable.login_logo,
                                contentScale = ContentScale.Crop
                            )
                        }

                        Spacer(
                            modifier = Modifier.width(3.dp)
                        )
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(3.dp)
                        ) {
                            Text(
                                text = "aman singh",
                                fontSize = 16.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.SemiBold,
                                lineHeight = 16.sp,
                                style = androidx.compose.ui.text.TextStyle(
                                    lineHeightStyle = LineHeightStyle(
                                        alignment = LineHeightStyle.Alignment.Center,
                                        trim = LineHeightStyle.Trim.Both
                                    )
                                )
                            )

                            Text(
                                text = "Rider Partner",
                                fontSize = 12.sp,
                                color = Color.Gray,
                                lineHeight = 12.sp,
                                style = androidx.compose.ui.text.TextStyle(
                                    lineHeightStyle = LineHeightStyle(
                                        alignment = LineHeightStyle.Alignment.Center,
                                        trim = LineHeightStyle.Trim.Both
                                    )
                                )
                            )

                            Text(
                                text = "7566850362",
                                fontSize = 11.sp,
                                color = Color.Gray,
                                lineHeight = 11.sp,
                                style = androidx.compose.ui.text.TextStyle(
                                    lineHeightStyle = LineHeightStyle(
                                        alignment = LineHeightStyle.Alignment.Center,
                                        trim = LineHeightStyle.Trim.Both
                                    )
                                )
                            )
                        }

                        // Call button
                        Box(
                            modifier = Modifier
                                .size(35.dp)
                                .clip(CircleShape)
                                .background(
                                    color = Color(0xFFE8F3E9)
                                )
                                .clickable {
                                    // call action
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            CustomIcon(
                                icon = Icons.Rounded.Call
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                ProfileMenuItem(
                    title = "My Profile",
                    subtitle = "View & edit profile",
                    icon = Icons.Outlined.Person,
                    iconBoxColor = Color(0xFFE8F0FE),
                    iconTint = Color(0xFF3B82F6),
                    onClick = { }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ProfileMenuItem(
                    title = "Wallet & Earnings",
                    subtitle = "View balance & payouts",
                    icon = Icons.Outlined.AccountBalanceWallet,
                    iconBoxColor = Color(0xFFF1F4E0),
                    iconTint = Color(0xFF8B9A3D),
                    onClick = { }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ProfileMenuItem(
                    title = "Trip History",
                    subtitle = "Your completed rides",
                    icon = Icons.Outlined.History,
                    iconBoxColor = Color(0xFFF1F4E0),
                    iconTint = Color(0xFF8B9A3D),
                    onClick = { }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ProfileMenuItem(
                    title = "Passes",
                    subtitle = "View & manage passes",
                    icon = Icons.Outlined.ConfirmationNumber,
                    iconBoxColor = Color(0xFFEDEDED),
                    iconTint = Color(0xFF757575),
                    onClick = { }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ProfileMenuItem(
                    title = "App Language",
                    subtitle = "Change app language",
                    icon = Icons.Outlined.Language,
                    iconBoxColor = Color(0xFFFDEEE0),
                    iconTint = Color(0xFFE8A33D),
                    onClick = { }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ProfileMenuItem(
                    title = "Change Role",
                    subtitle = "Switch between roles",
                    icon = Icons.Outlined.SwapHoriz,
                    iconBoxColor = Color(0xFFEDEDED),
                    iconTint = Color(0xFF757575),
                    onClick = { }
                )
                Spacer(modifier = Modifier.height(10.dp))

                ProfileMenuItem(
                    title = "See Complaint",
                    subtitle = "View your submitted complaint",
                    icon = Icons.Outlined.ReportProblem,
                    iconBoxColor = Color(0xFFE8F0FE),
                    iconTint = Color(0xFF3B82F6),
                    onClick = { }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ProfileMenuItem(
                    title = "Delete Account",
                    subtitle = "Permanently delete your account",
                    icon = Icons.Outlined.DeleteForever,
                    iconBoxColor = Color(0xFFFCE8E8),
                    iconTint = Color(0xFFE53935),
                    onClick = { }
                )

                Spacer(modifier = Modifier.height(15.dp))

                AppButton(
                    text = "Logout",
                    onClick = {

                    },
                    textColor = Color.White,
                    backgroundColor = Color.Red
                )

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}