package com.example.driverapp.ui.components
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.animation.core.*

@Composable
fun CustomOtp(

    otpValue: String,

    onOtpChange: (String) -> Unit,

    modifier: Modifier = Modifier,

    otpLength: Int = 6,

    boxSize: Dp = 55.dp,

    cornerRadius: Dp = 12.dp,

    activeBorderColor: Color = Color.Black,

    inactiveBorderColor: Color = Color.Gray,

    activeBorderWidth: Dp = 2.dp,

    inactiveBorderWidth: Dp = 1.dp,

    backgroundColor: Color = Color.White,

    textColor: Color = Color.Black,

    cursorColor: Color = Color.Black,

    spacing: Dp = 8.dp,

    isEnabled: Boolean = true,

    isError: Boolean = false,

    errorBorderColor: Color = Color.Red

) {

    val transition = rememberInfiniteTransition(label = "")

    val cursorAlpha by transition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(500),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )

    BasicTextField(

        value = otpValue,

        onValueChange = {

            if (it.length <= otpLength && it.all(Char::isDigit)) {
                onOtpChange(it)
            }

        },

        enabled = isEnabled,

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),

        decorationBox = {

            Row(
                horizontalArrangement = Arrangement.spacedBy(spacing)
            ) {

                repeat(otpLength) { index ->

                    val digit = otpValue.getOrNull(index)?.toString() ?: ""

                    val isActive = index == otpValue.length

                    Box(
                        modifier = Modifier
                            .size(boxSize)
                            .border(
                                width = when {
                                    isError -> activeBorderWidth
                                    isActive -> activeBorderWidth
                                    else -> inactiveBorderWidth
                                },
                                color = when {
                                    isError -> errorBorderColor
                                    isActive -> activeBorderColor
                                    else -> inactiveBorderColor
                                },
                                shape = RoundedCornerShape(cornerRadius)
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        when {

                            digit.isNotEmpty() -> {

                                Text(
                                    text = digit,
                                    color = textColor,
                                    fontSize = 20.sp
                                )

                            }

                            isActive && otpValue.length < otpLength -> {

                                Text(
                                    text = "|",
                                    color = cursorColor,
                                    modifier = Modifier.alpha(cursorAlpha)
                                )

                            }

                        }

                    }

                }

            }

        }

    )

}