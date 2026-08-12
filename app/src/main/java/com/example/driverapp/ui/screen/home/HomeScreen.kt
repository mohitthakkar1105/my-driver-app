package com.example.driverapp.ui.screen.home
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.example.driverapp.R
import com.example.driverapp.ui.components.CustomImage
import com.example.driverapp.ui.components.HomeAppBar
import com.example.driverapp.ui.navigation.AppController

@Composable
fun HomeScreen(
    appController: AppController
) {
    Scaffold(
        topBar = {
            HomeAppBar()
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            CustomImage(
                image = R.drawable.app_background,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}