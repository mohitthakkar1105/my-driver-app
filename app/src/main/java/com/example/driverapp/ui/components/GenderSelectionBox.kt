package com.example.driverapp.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.driverapp.ui.theme.DriverBlack

@Composable
fun GenderSelectionBox(
    gender : String,
    index : Int,
    selectGender : (Int) -> Unit,
    selectedIndex : Int
){
    Box(
        modifier = Modifier
            .padding(
                horizontal = 20.dp
            )
            .width(80.dp)
            .height(
                40.dp
            )
            .background(
                color = if (index==selectedIndex) Color.Black else Color.Gray.copy(
                    alpha = 0.1f
                ),
                shape = RoundedCornerShape(10.dp),
            ).clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = {
                    selectGender(index)
                }
            )
            .border(
                color = DriverBlack.copy(
                    alpha = 0.5f
                ),
                width = 1.dp,
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = gender,
            color = if(index==selectedIndex) Color.White else Color.Black
        )
    }
}