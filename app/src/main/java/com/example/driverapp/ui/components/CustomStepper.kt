package com.example.learnjetpackcompose.stepper
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Stepper(

    currentStep: Int,

    labels: List<String>,

    activeColor: Color = Color.Black,

    inactiveColor: Color = Color.Gray.copy(alpha = 0.3f)

) {

    val totalSteps = labels.size

    val progress = currentStep.toFloat() / totalSteps.toFloat()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            labels.forEachIndexed { index, label ->

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = label,
                        fontSize = 13.sp,
                        color = if (index + 1 <= currentStep)
                            activeColor
                        else
                            Color.Gray

                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Box(
                        modifier = Modifier
                            .size(7.dp)
                            .background(
                                color = if (index + 1 <= currentStep)
                                    activeColor
                                else
                                    Color.Gray,
                                shape = CircleShape
                            )
                    )
                }
            }
        }
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(
                    inactiveColor,
                    RoundedCornerShape(20.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progress)
                    .height(5.dp)
                    .background(
                        activeColor,
                        RoundedCornerShape(20.dp)
                    )
            )
        }
    }
}