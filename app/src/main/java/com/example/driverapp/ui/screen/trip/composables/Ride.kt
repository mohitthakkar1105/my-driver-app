package com.example.driverapp.ui.screen.trip.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.driverapp.ui.components.RideHistoryCard

@Composable
fun Ride() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .background(
                color = Color.Transparent
            )
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            RideHistoryCard()
            Spacer(modifier = Modifier.height(10.dp))
            RideHistoryCard()
            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}