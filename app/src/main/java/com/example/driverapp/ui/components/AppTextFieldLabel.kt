package com.example.driverapp.ui.components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.driverapp.ui.theme.DriverBlack

@Composable
fun AppTextFieldLabel(
    label : String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 15.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = label,
            color = DriverBlack,
            fontSize = 15.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.W400
        )
    }
}