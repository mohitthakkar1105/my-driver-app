package com.example.driverapp.ui.navigation

import kotlinx.serialization.Serializable

sealed interface Screen

/**
 * Splash
 */
@Serializable
data object SplashRoute : Screen

/**
 * Authentication
 */
@Serializable
data object LoginRoute : Screen

@Serializable
data class OtpRoute(
    val phoneNumber: String
) : Screen


@Serializable
data object RegistrationRoute : Screen