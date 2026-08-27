package com.example.driverapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.driverapp.ui.screen.home.HomeScreen
import com.example.driverapp.ui.screen.registration.Registration
import com.example.driverapp.ui.screen.login.Login
import com.example.driverapp.ui.screen.main.MainScreen
import com.example.driverapp.ui.screen.myVehicle.MyVehicleScreen
import com.example.driverapp.ui.screen.otp.Otp
import com.example.driverapp.ui.screen.profile.Profile
import com.example.driverapp.ui.screen.splash.Splash
import com.example.driverapp.ui.screen.subProfile.SubProfile

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

        composable<MainRoute> {
            MainScreen(
                appController = appController
            )
        }

        composable<ProfileRoute> {
            Profile(
                appController = appController
            )
        }

        composable<SubProfileRoute> {
            SubProfile(
                appController = appController
            )
        }

        composable<MyVehicleRoute> {
            MyVehicleScreen(
                appController = appController
            )
        }

    }

}

