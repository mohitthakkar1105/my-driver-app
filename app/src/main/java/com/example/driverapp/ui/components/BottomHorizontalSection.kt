package com.example.driverapp.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.driverapp.ui.theme.DriverWhite

@Composable
fun BottomHorizontalSection(
    modifier: Modifier = Modifier,
    color: Color,
    icon: ImageVector,
    iconSize: Int,
    value: String,
    title: String,
    valueSize: Int = 18,
    valueSuffix: String,
    height: Int = 70,
    backgroundColor: Color? = null,
    backgroundBrush: Brush? = null,
    shadowElevation: Int = 8,
    borderColor: Color = Color.Transparent,
    borderSize: Int = 0,
    suffixIcon: ImageVector? = null
) {
    Box(
        modifier = modifier
            .height(height.dp)
            .border(
                color = borderColor,
                width = borderSize.dp,
                shape = RoundedCornerShape(15.dp)
            )
            .shadow(
                elevation = shadowElevation.dp,
                shape = RoundedCornerShape(15.dp)
            )
            .background(
                brush = backgroundBrush ?: Brush.linearGradient(
                    listOf(backgroundColor ?: DriverWhite, backgroundColor ?: DriverWhite),
                ),
                shape = RoundedCornerShape(15.dp)
            )
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(35.dp)
                    .background(
                        color = color.copy(
                            alpha = 0.1f
                        ),
                        shape = RoundedCornerShape(100),
                    )
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                CustomIcon(
                    icon = icon,
                    size = iconSize,
                    tint = color
                )
            }
            Spacer(modifier = Modifier.width(7.dp))
            Column(
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = title,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.W600
                )
                Row {
                    Text(
                        text = value,
                        fontSize = valueSize.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = valueSuffix,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            if(suffixIcon!=null)
            CustomIcon(
                icon = suffixIcon,
                size = 35,
                tint = Color(0xFF2E7D32)
            )
        }
    }
}