package com.example.driverapp.ui.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.driverapp.ui.components.AppBottomBar
import com.example.driverapp.ui.components.HomeAppBar
import com.example.driverapp.ui.components.PassesAppBar
import com.example.driverapp.ui.navigation.AppController
import com.example.driverapp.ui.screen.home.HomeScreen
import com.example.driverapp.ui.screen.home.HomeViewModel

@Composable
fun MainScreen(
    appController: AppController
) {
    var changeBottomNavIndex by remember {
        mutableStateOf(0)
    }

    val viewModel = viewModel<HomeViewModel>()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    Scaffold(
        bottomBar = {
            AppBottomBar(
                selectedIndex = changeBottomNavIndex,
                onItemClick = {
                    changeBottomNavIndex = it
                }
            )
        },
        topBar = {
            if (changeBottomNavIndex == 0) {
                HomeAppBar(
                    address = uiState.address
                )
            } else if (changeBottomNavIndex == 3) {
                PassesAppBar()
            }
        }
    ) { paddingValues ->
        when (changeBottomNavIndex) {
            0 -> HomeScreen(modifier = Modifier.padding(paddingValues))
            1 -> HomeScreen(modifier = Modifier.padding(paddingValues))
            2 -> HomeScreen(modifier = Modifier.padding(paddingValues))
            3 -> HomeScreen(modifier = Modifier.padding(paddingValues))
        }
    }
}