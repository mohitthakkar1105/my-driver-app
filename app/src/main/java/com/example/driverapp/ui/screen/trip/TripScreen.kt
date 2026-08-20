package com.example.driverapp.ui.screen.trip

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.driverapp.R
import com.example.driverapp.ui.components.CustomImage
import com.example.driverapp.ui.screen.main.MainEvent
import com.example.driverapp.ui.screen.main.MainViewModel
import com.example.driverapp.ui.screen.trip.composables.ActiveRide
import com.example.driverapp.ui.screen.trip.composables.Ride
import kotlinx.coroutines.launch

@Composable
fun TripScreen(
    modifier: Modifier = Modifier
) {

    val viewModelMain = viewModel<MainViewModel>()

    val uiStateMainScreen by viewModelMain.uiState.collectAsStateWithLifecycle()

    val scope = rememberCoroutineScope()

    val pagerState = rememberPagerState(
        initialPage = uiStateMainScreen.tabIndexTrip,
        pageCount = { 2 }
    )

    LaunchedEffect(uiStateMainScreen.tabIndexTrip) {
        if (uiStateMainScreen.tabIndexTrip == 0) {
            scope.launch {
                pagerState.animateScrollToPage(0)
            }
        } else {
            scope.launch {
                pagerState.animateScrollToPage(1)
            }
        }
    }

    LaunchedEffect(pagerState.currentPage) {
        viewModelMain.onEvent(MainEvent.OnTabChangeTrip(pagerState.currentPage))
    }


    Box(
        modifier = modifier.fillMaxSize()
    ) {
        CustomImage(
            image = R.drawable.app_background,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
        ) { pagerState ->
            when (pagerState) {
                0 -> {
                    ActiveRide()
                }

                1 -> {
                    Ride()
                }
            }
        }
    }
}