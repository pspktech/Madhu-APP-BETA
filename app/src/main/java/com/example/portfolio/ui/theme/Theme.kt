package com.example.portfolio.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = Primary, secondary = Secondary, tertiary = Tertiary,
    background = Background, surface = Surface, onPrimary = OnPrimary, onSurface = OnSurface
)
private val DarkColors = darkColorScheme(primary = Primary, secondary = Secondary, tertiary = Tertiary)

@Composable
fun PortfolioTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = AppTypography,
        content = content
    )
}
