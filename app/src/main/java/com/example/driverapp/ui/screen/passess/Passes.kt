package com.example.driverapp.ui.screen.passess

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
import com.example.driverapp.ui.screen.passess.composable.AvailablePlan
import com.example.driverapp.ui.screen.passess.composable.PassHistory
import kotlinx.coroutines.launch

@Composable
fun Passes(
    modifier: Modifier = Modifier
) {

    val viewModelMain = viewModel<MainViewModel>()

    val uiStateMainScreen by viewModelMain.uiState.collectAsStateWithLifecycle()

    val scope = rememberCoroutineScope()

    val pagerState = rememberPagerState(
        initialPage = uiStateMainScreen.tabIndex,
        pageCount = { 2 }
    )

    LaunchedEffect(pagerState.currentPage) { // ye jab chalega jab currentpage chaneg hoga
        viewModelMain.onEvent(MainEvent.OnTabChange(pagerState.currentPage))
    }

    LaunchedEffect(uiStateMainScreen.tabIndex) { // ye jab chalega jab currentpage chaneg hoga
        if (uiStateMainScreen.tabIndex == 0) {
            scope.launch {
                pagerState.animateScrollToPage(0)
            }

        } else {
            scope.launch {
                pagerState.animateScrollToPage(1)
            }
        }
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
                    AvailablePlan()
                }

                1 -> {
                    PassHistory()
                }
            }
        }
    }
}

