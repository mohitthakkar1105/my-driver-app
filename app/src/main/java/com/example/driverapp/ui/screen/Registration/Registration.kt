package com.example.driverapp.ui.screen.Registration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.driverapp.ui.components.AppButton
import com.example.driverapp.ui.components.CustomIcon
import com.example.driverapp.ui.navigation.AppController
import com.example.driverapp.ui.theme.DriverBlack
import com.example.learnjetpackcompose.stepper.Stepper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registration(
    appController: AppController
) {
    val labels = listOf(
        "Personal Information",
        "Documents Information",
        "Aadhar Information",
        "Vehicle Information"
    )

    val scope = rememberCoroutineScope()


    val pagerState = rememberPagerState(
        pageCount = { labels.size }
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Registration",
                            fontSize = 20.sp
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        CustomIcon(
                            icon = Icons.AutoMirrored.Filled.ArrowBack
                        )
                    }
                }
            )
        },
        bottomBar = {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .background(MaterialTheme.colorScheme.surface)
                    .height(70.dp)
            ) {

                AppButton(
                    text = "Next",
                    onClick = {

                    },
                    modifier = Modifier.padding(horizontal = 20.dp),
                    cornerRadius = 10
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.surface
                )
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Stepper(
                    currentStep = pagerState.currentPage + 1,
                    labels = listOf(
                        "Personal",
                        "Documents",
                        "Aadhar",
                        "Vehicle"
                    )
                )
                Spacer(
                    modifier = Modifier.height(15.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 20.dp
                        )
                ) {
                    Text(
                        text = labels[pagerState.currentPage],
                        fontSize = 20.sp,
                        color = DriverBlack,
                        fontWeight = FontWeight.W700
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Step ${pagerState.currentPage + 1}/4",
                        fontSize = 17.sp,
                        color = DriverBlack,
                    )
                }
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                HorizontalPager(
                    state = pagerState,
                    userScrollEnabled = false,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = Color.White
                        )
                ) {

                }
            }
        }
    }
}
