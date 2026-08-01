package com.example.driverapp.ui.screen.Otp

import android.text.style.StyleSpan
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.driverapp.R
import com.example.driverapp.ui.components.AppButton
import com.example.driverapp.ui.components.CustomIcon
import com.example.driverapp.ui.components.CustomImage
import com.example.driverapp.ui.components.CustomOtp
import com.example.driverapp.ui.navigation.AppController
import com.example.driverapp.ui.navigation.RegistrationRoute
import com.example.driverapp.ui.screen.Registration.Registration
import com.example.driverapp.ui.screen.login.LoginViewModel
import com.example.driverapp.ui.theme.DriverBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Otp(
    appController: AppController,
    mobileNumber: String
) {

    var otpValue by remember {
        mutableStateOf("")
    }

    val viewModel = viewModel<OtpViewModel>()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { uiEffect ->
            when (uiEffect) {
                is OtpUiEffect.NavigateToRegistration -> {
                    appController.navController.navigate(RegistrationRoute)
                }
            }
        }

    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomImage(
            image = R.drawable.app_background,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = {

                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    ),
                    navigationIcon = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            CustomIcon(
                                icon = Icons.AutoMirrored.Filled.ArrowBack
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CustomImage(
                    image = R.drawable.login_logo,
                )
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                Text(
                    text = "Verify your number",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
                Text(
                    text = "Enter OTP sent to  +91$mobileNumber",
                    style = MaterialTheme.typography.labelMedium,
                    color = DriverBlack.copy(
                        alpha = 0.5f
                    )
                )
                Spacer(
                    modifier = Modifier.height(30.dp)
                )
                CustomOtp(
                    otpValue = otpValue,
                    onOtpChange = {
                        otpValue = it
                    },
                    boxSize = 50.dp
                )
                Spacer(
                    modifier = Modifier.height(15.dp)
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = DriverBlack.copy(
                                    alpha = 0.5f
                                ),
                                fontSize = 14.sp
                            )
                        ) {
                            append("Didn't receive OTP? ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = DriverBlack,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        ) {
                            append("Resend OTP")
                        }
                    }
                )
                Spacer(
                    modifier = Modifier.height(15.dp)
                )
                Row() {
                    CustomIcon(
                        icon = Icons.Default.Edit,
                        tint = DriverBlack.copy(
                            alpha = 0.5f
                        ),
                        size = 18
                    )
                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )
                    Text(
                        "Change number",
                        style = MaterialTheme.typography.labelMedium.copy(
                            textDecoration = TextDecoration.Underline
                        ),
                        color = DriverBlack.copy(
                            alpha = 0.5f
                        )
                    )
                }
                Spacer(
                    modifier = Modifier.height(30.dp)
                )
                AppButton(
                    text = "Verify OTP",
                    modifier = Modifier.padding(horizontal = 25.dp),
                    onClick = {
                        viewModel.onEvent(
                            OtpEvent.OnVerifyOtp
                        )
                    },
                    cornerRadius = 30
                )
            }
        }
    }
}