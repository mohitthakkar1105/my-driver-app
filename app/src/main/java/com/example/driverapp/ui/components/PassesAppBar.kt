package com.example.driverapp.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PassesAppBar(
    tab : Int,
    changeTab : (Int) -> Unit
) {


    // Row ki actual pixel width yahan store hogi
    var rowWidthPx by remember { mutableIntStateOf(0) }
    val density = LocalDensity.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFB7C145).copy(alpha = 0.7f))
            .statusBarsPadding()
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.fillMaxWidth()) {
                CustomIcon(icon = Icons.AutoMirrored.Filled.ArrowBack, tint = Color.White)
                Spacer(modifier = Modifier.width(30.dp))
                Text(text = "Ride Passes", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.weight(1f))
                CustomIcon(icon = Icons.Default.Refresh, tint = Color.Gray)
            }

            Spacer(modifier = Modifier.height(25.dp))

            // Tabs Row — iski width naapenge onSizeChanged se
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .onSizeChanged { size ->
                        rowWidthPx = size.width
                    }
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            changeTab(0)
                          },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Available Plans",
                        fontSize = if (tab==0) 13.sp else 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (tab == 0) Color.Black else Color.Gray
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            changeTab(1)
                          },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Pass History",
                        fontSize = if (tab==1) 13.sp else 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (tab == 1) Color.Black else Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Dynamic width — naapi hui width ka aadha
            val thumbWidthDp = with(density) { (rowWidthPx / 2).toDp() }

            val thumbOffset by animateDpAsState(
                targetValue = if (tab == 1) thumbWidthDp else 0.dp,
                label = "IndicatorAnimation"
            )

            Box(
                modifier = Modifier
                    .width(thumbWidthDp)
                    .height(3.dp)
                    .offset(x = thumbOffset)
                    .background(color = Color(0xFFB7C145))
            )
        }
    }
}