package com.example.driverapp.ui.screen.home

import android.location.Geocoder
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AirlineSeatReclineExtra
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.material.icons.rounded.CheckCircleOutline
import androidx.compose.material.icons.rounded.CurrencyRupee
import androidx.compose.material.icons.rounded.DirectionsCar
import androidx.compose.material.icons.rounded.LocalShipping
import androidx.compose.material.icons.rounded.Route
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.TrendingUp
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import com.example.driverapp.R
import com.example.driverapp.ui.components.CustomImage
import com.example.driverapp.ui.components.HomeAppBar
import com.example.driverapp.ui.navigation.AppController
import com.example.driverapp.utils.LocationService.requestLocationUpdates
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.driverapp.ui.components.AppBottomBar
import com.example.driverapp.ui.components.AppToggle
import com.example.driverapp.ui.components.BottomHorizontalSection
import com.example.driverapp.ui.components.ChangeRoleBox
import com.example.driverapp.ui.components.StatsBox
import com.example.driverapp.ui.components.WavingHand

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    val geocoder = Geocoder(
        context,
    )

    val viewModel = viewModel<HomeViewModel>()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    var isOnline by remember {
        mutableStateOf(false)
    }

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

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        CustomImage(
            image = R.drawable.app_background,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 20.dp,
                    vertical = 10.dp
                ),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.Transparent
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
                    AppToggle(
                        isOnline = isOnline,
                        onToggle = {
                            isOnline = !isOnline
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(18.dp))
            Column(
                modifier = Modifier.verticalScroll(
                    state = rememberScrollState(),
                ),
            ) {
                Row {
                    Text(
                        text = "Hello",
                        fontSize = 42.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    WavingHand()
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "CabNCarry Captain",
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Ready to earn? Go online & accept rides",
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W500
                )
                Spacer(modifier = Modifier.height(21.dp))
                Text(
                    text = "YOUR ROLE",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W900
                )
                Spacer(modifier = Modifier.height(7.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ChangeRoleBox(
                        icon = Icons.Rounded.DirectionsCar,
                        title = "Rider",
                        color = Color(0xFFB7C145),
                        paddingEnd = 10
                    )
                    ChangeRoleBox(
                        icon = Icons.Rounded.AirlineSeatReclineExtra,
                        title = "Intercity",
                        color = Color(0xFFFFA733),
                        paddingEnd = 10
                    )
                    ChangeRoleBox(
                        icon = Icons.Rounded.LocalShipping,
                        title = "Porter",
                        color = Color(0xFF1E3BCC),
                        paddingEnd = 0
                    )
                }
                Spacer(modifier = Modifier.height(27.dp))
                Text(
                    text = "YOUR STATS",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W900
                )
                Spacer(modifier = Modifier.height(7.dp))
                Row() {
                    StatsBox(
                        icon = Icons.Rounded.Route,
                        number = 0,
                        title = "Total",
                        color = Color(0xFF1565C0),
                        paddingEnd = 10
                    )
                    StatsBox(
                        icon = Icons.Rounded.CheckCircleOutline,
                        number = 0,
                        title = "Done",
                        color = Color(0xFF2E7D32),
                        paddingEnd = 10
                    )
                    StatsBox(
                        icon = Icons.Rounded.CalendarToday,
                        number = 0,
                        title = "This Month",
                        color = Color(0xFF8A9433),
                        paddingEnd = 0
                    )
                }
                Spacer(modifier = Modifier.height(25.dp))
                Row {
                    BottomHorizontalSection(
                        color = Color(0xFFB7C145),
                        icon = Icons.Rounded.Star,
                        iconSize = 40,
                        modifier = Modifier.weight(1f),
                        title = "Ratings",
                        value = "0 ",
                        valueSuffix = "/ 5",
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    BottomHorizontalSection(
                        color = Color(0xFFB7C145),
                        icon = Icons.Rounded.Wallet,
                        iconSize = 40,
                        modifier = Modifier.weight(1f),
                        title = "Wallets",
                        value = "₹1235.12",
                        valueSuffix = ""
                    )
                }
                Spacer(
                    modifier = Modifier.height(25.dp)
                )
                BottomHorizontalSection(
                    color = Color(0xFFB7C145),
                    icon = Icons.Rounded.CurrencyRupee,
                    iconSize = 50,
                    value = "₹0",
                    title = "Total Earned",
                    valueSuffix = "",
                    valueSize = 30,
                    modifier = Modifier
                        .fillMaxWidth(),
                    height = 90,
                    shadowElevation = 0,
                    backgroundBrush = Brush.linearGradient(
                        listOf(
                            Color(0xFFF4F7D0),
                            Color(0xFFB7C145).copy(alpha = 0.3f)
                        )
                    ),
                    borderColor = Color(0xFFB7C145),
                    borderSize = 1,
                    suffixIcon = Icons.Rounded.TrendingUp,
                )
                Spacer(
                    modifier = Modifier.height(150.dp)
                )
            }
        }
    }

}