package com.example.driverapp.ui.screen.login
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.driverapp.R
import com.example.driverapp.ui.components.AppButton
import com.example.driverapp.ui.components.CustomImage
import com.example.driverapp.ui.navigation.AppController
import com.example.driverapp.ui.navigation.OtpRoute
import com.example.driverapp.ui.theme.DriverBlack
import com.example.driverapp.ui.theme.DriverGrey
import com.example.driverapp.ui.theme.DriverWhite

@Composable
fun Login(
    appController: AppController
) {

    var name by remember {
        mutableStateOf("")
    }

    val viewModel = viewModel<LoginViewModel>()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { uiEffect ->
            when (uiEffect) {
                is  LoginUiEffect.NavigateToOtp -> {
                    appController.navController.navigate(OtpRoute(
                        phoneNumber = name
                    ))
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

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier.height(100.dp)
            )
            CustomImage(
                image = R.drawable.login_logo,
                modifier = Modifier.height(180.dp)
            )
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            Text(
                text = "# Enter your number",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Text(
                text = "We'll send an OTP to verify your number",
                style = MaterialTheme.typography.labelMedium,
                color = DriverBlack.copy(
                    alpha = 0.5f
                )
            )
            Spacer(
                modifier = Modifier.height(30.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 30.dp)
                    .background(
                        color = DriverWhite,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .border(
                        color = DriverGrey,
                        shape = RoundedCornerShape(15.dp),
                        width = 1.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Spacer(
                        modifier = Modifier.width(15.dp)
                    )
                    Text(
                        text = "🇮🇳",
                        fontSize = 20.sp
                    )
                    Spacer(
                        modifier = Modifier.width(5.dp)
                    )
                    Text(
                        text = "+91",
                        fontSize = 17.sp,
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold
                        ),
                        modifier = Modifier.padding(top = 1.5.dp)
                    )
                    Spacer(
                        modifier = Modifier.width(5.dp)
                    )
                    VerticalDivider(
                        modifier = Modifier.fillMaxHeight().padding(vertical = 15.dp),
                        thickness = 1.dp,
                        color = DriverGrey
                    )
                    OutlinedTextField(
                        value = name,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone
                        ),
                        onValueChange = {
                            name = it
                        },
                        modifier = Modifier.weight(1f), // ye flutter me expanded jesa hai jo space bachi ye textfield le lega
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            disabledBorderColor = Color.Transparent,
                            errorBorderColor = Color.Transparent
                        ),
                        placeholder = {
                            Text(
                                text = "Enter phone number",
                                color = DriverGrey
                            )
                        }
                    )
                }
            }
            Spacer(
                modifier = Modifier.height(15.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = uiState.isChecked,
                    onCheckedChange = {
                        viewModel.onEvent(LoginEvent.TickCheck)
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = DriverBlack,
                        uncheckedColor = DriverBlack,
                        checkmarkColor = DriverWhite
                    )
                )
                Spacer(
                    modifier = Modifier.width(5.dp)
                )
                Text(
                    text = "I agree to the Terms & Conditions",
                    style = MaterialTheme.typography.labelMedium,
                    color = DriverBlack.copy(
                        alpha = 0.5f
                    )
                )
            }
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            AppButton(
                text = "Continue",
                modifier = Modifier.padding(horizontal = 30.dp),
                onClick = {
                    viewModel.onEvent(
                        LoginEvent.SendOtp
                    )
                },
                enabled = uiState.isChecked,
                cornerRadius = 30,
            )
            Spacer(
                modifier = Modifier.height(15.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "",
                    tint = Color.Red
                )
                Spacer(
                    modifier = Modifier.width(8.dp)
                )
                Text(
                    text = "Powered By Bharat",
                    style = MaterialTheme.typography.labelMedium,
                    color = DriverBlack.copy(
                        alpha = 0.5f
                    )
                )
            }
        }
    }
}