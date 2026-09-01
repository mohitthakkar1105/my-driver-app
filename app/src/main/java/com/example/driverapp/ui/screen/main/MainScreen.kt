package com.example.driverapp.ui.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.driverapp.ui.components.TripAppBar
import com.example.driverapp.ui.navigation.AppController
import com.example.driverapp.ui.navigation.NotificationRoute
import com.example.driverapp.ui.navigation.ProfileRoute
import com.example.driverapp.ui.screen.home.HomeScreen
import com.example.driverapp.ui.screen.home.HomeViewModel
import com.example.driverapp.ui.screen.passess.Passes
import com.example.driverapp.ui.screen.trip.TripScreen

@Composable
fun MainScreen(
    appController: AppController
) {
    var changeBottomNavIndex by remember {
        mutableStateOf(0)
    }

    val viewModel = viewModel<HomeViewModel>()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val viewModelMain = viewModel<MainViewModel>()

    val uiStateMainScreen by viewModelMain.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModelMain.uiEffect.collect { uiEffect ->
            when (uiEffect) {
                MainUiEffect.NavigateToProfile -> {
                    appController.navController.navigate(ProfileRoute)
                }

                MainUiEffect.NavigateToNotification -> {
                    appController.navController.navigate(NotificationRoute)
                }
            }
        }
    }

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
                    address = uiState.address,
                    goToProfile = {
                        viewModelMain.onEvent(
                            MainEvent.OnProfileClick
                        )
                    },
                    goToNotification = {
                        viewModelMain.onEvent(
                            MainEvent.OnNotificationClick
                        )
                    }
                )
            } else if (changeBottomNavIndex == 1) {
                TripAppBar(
                    tab = uiStateMainScreen.tabIndexTrip,
                    changeTab = {
                        viewModelMain.onEvent(MainEvent.OnTabChangeTrip(it))
                    }
                )
            } else if (changeBottomNavIndex == 3) {
                PassesAppBar(
                    tab = uiStateMainScreen.tabIndex,
                    changeTab = {
                        viewModelMain.onEvent(MainEvent.OnTabChange(it))
                    }
                )
            }
        }
    ) { paddingValues ->
        when (changeBottomNavIndex) {
            0 -> HomeScreen(modifier = Modifier.padding(paddingValues))
            1 -> TripScreen(modifier = Modifier.padding(paddingValues))
            2 -> HomeScreen(modifier = Modifier.padding(paddingValues))
            3 -> Passes(modifier = Modifier.padding(paddingValues))
        }
    }
}