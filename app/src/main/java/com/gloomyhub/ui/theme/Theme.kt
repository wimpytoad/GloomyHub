package com.gloomyhub.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette =
    darkColors(
        primary = Brown,
        primaryVariant = BrownDark,
        secondary = Grey,
        background = Background,
        surface = BackgroundDark,
        onBackground = Background,
        onSurface = BackgroundDark
    )

private val LightColorPalette =
    lightColors(
        primary = Brown,
        primaryVariant = BrownDark,
        secondary = Grey,
        background = Background,
        surface = BackgroundDark,
        onBackground = Background,
        onSurface = BackgroundDark
    )

@Composable
fun GloomyHubTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(colors = colors, typography = Typography, shapes = Shapes, content = content)
}