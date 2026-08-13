package com.example.driverapp.ui.screen.home

import android.location.Geocoder
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import com.example.driverapp.R
import com.example.driverapp.ui.components.CustomImage
import com.example.driverapp.ui.components.HomeAppBar
import com.example.driverapp.ui.navigation.AppController
import com.example.driverapp.utils.LocationService.requestLocationUpdates
import androidx.compose.ui.platform.LocalLocale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    appController: AppController
) {

    val context = LocalContext.current

    val geocoder = Geocoder(
        context,
        LocalLocale.current.platformLocale
    )

    val viewModel = viewModel<HomeViewModel>()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    var isOnline by remember {
        mutableStateOf(false)
    }

    val thumbOffset by animateDpAsState(
        targetValue = if (isOnline) 28.dp else 0.dp,
        label = "ToggleAnimation"
    )

    LaunchedEffect(Unit) {
        requestLocationUpdates(
            context = context
        ) { lat, lng ->

            viewModel.onEvent(
                HomeEvent.fetchingLatLong(
                    lat = lat,
                    lng = lng
                )
            )

            val addresses =
                geocoder.getFromLocation(
                    lat,
                    lng,
                    1
                )

            val address =
                addresses?.firstOrNull()

            val city =
                address?.locality ?: ""

            val state =
                address?.adminArea ?: ""

            viewModel.onEvent(
                HomeEvent.fetchingAddress(
                    address = "$city, $state"
                )
            )
        }
    }


    Scaffold(
        topBar = {
            HomeAppBar(
                address = uiState.address
            )
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.Transparent
                    )
                    .padding(
                        20.dp
                    )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "You are online",
                        fontSize = 21.sp,
                        color = Color(0xFF388E3C).copy(
                            alpha = 0.8f
                        ),
                        fontWeight = FontWeight.W400
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember {
                                    MutableInteractionSource()
                                }
                            ) {
                                isOnline = !isOnline
                            } // parent bada
                    ) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .width(60.dp)
                                .height(23.dp)
                                .background(
                                    Color.Gray.copy(alpha = 0.4f),
                                    RoundedCornerShape(28.dp)
                                )
                        )

                        Box(
                            modifier = Modifier
                                .size(33.dp)
                                .offset(x = thumbOffset, y = (3).dp)
                                .background(
                                    Color.White,
                                    CircleShape
                                )
                        )
                    }
                }
            }
        }
    }
}