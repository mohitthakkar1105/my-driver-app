package com.example.driverapp.ui.screen.splash
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.driverapp.R
import com.example.driverapp.ui.navigation.AppController
import com.example.driverapp.ui.navigation.LoginRoute
import com.example.driverapp.ui.navigation.SplashRoute


@Composable
fun Splash(
    appController: AppController
){
    val viewModel = viewModel<SplashViewModel>()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                is SplashUiEffect.NavigateToLogin -> {
                    appController.navController.navigate(LoginRoute) {

                        popUpTo<SplashRoute> {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                }
            }
        }
    }

    Scaffold() {
        _->
        Box(
            modifier = Modifier.fillMaxSize().background(
                color = MaterialTheme.colorScheme.background
            ),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id =R.drawable.default_logo),
                contentDescription = "",
                modifier = Modifier.size(200.dp)
            )
        }
    }
}