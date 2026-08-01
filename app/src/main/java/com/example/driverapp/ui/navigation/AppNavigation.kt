package com.example.driverapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.driverapp.ui.navigation.SplashRoute
import com.example.driverapp.ui.navigation.LoginRoute
import com.example.driverapp.ui.navigation.OtpRoute
import com.example.driverapp.ui.screen.Otp.Otp
import com.example.driverapp.ui.screen.Registration.Registration
import com.example.driverapp.ui.screen.login.Login
import com.example.driverapp.ui.screen.splash.Splash

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val appController = remember {
        AppController(navController)
    }

    NavHost(
        navController = navController,
        startDestination = SplashRoute
    ) {

        composable<SplashRoute> {
            Splash(
                appController = appController
            )
        }

        composable<LoginRoute> {
            Login(
                appController = appController
            )
        }

        composable<OtpRoute> {

            val otp = it.toRoute<OtpRoute>()

            Otp(
                appController = appController,
                mobileNumber = otp.phoneNumber
            )
        }


        composable<RegistrationRoute> {
            Registration(
                appController = appController
            )
        }

    }

}

