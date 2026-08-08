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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.driverapp.ui.theme.DriverBlack

@Composable
fun AppTextFieldLabel(
    label : String,
    fontWeight: FontWeight = FontWeight.W400,
    fontSize : TextUnit = 15.sp
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
            fontSize = fontSize,
            textAlign = TextAlign.Start,
            fontWeight = fontWeight
        )
    }
}