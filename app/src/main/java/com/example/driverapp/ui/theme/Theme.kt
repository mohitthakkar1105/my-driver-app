package com.example.driverapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(

    primary = DriverPrimary,
    secondary = DriverPrimaryLight,

    background = DriverBackground,
    surface = DriverSurface,

    onPrimary = DriverWhite,
    onBackground = DriverTextPrimary,
    onSurface = DriverTextPrimary,

    error = DriverError
)

private val DarkColorScheme = darkColorScheme(

    // Intentionally same as Light Theme
    primary = DriverPrimary,
    secondary = DriverPrimaryLight,

    background = DriverBackground,
    surface = DriverSurface,

    onPrimary = DriverWhite,
    onBackground = DriverTextPrimary,
    onSurface = DriverTextPrimary,

    error = DriverError
)

@Composable
fun DriverAppTheme(

    darkTheme: Boolean = isSystemInDarkTheme(),

    content: @Composable () -> Unit

) {

    val colorScheme =
        if (darkTheme) DarkColorScheme
        else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}