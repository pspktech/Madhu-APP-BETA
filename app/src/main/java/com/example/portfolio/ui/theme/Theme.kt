package com.madhupatel.portfolio.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val ColorOutline = androidx.compose.ui.graphics.Color(0x334F6B93)

private val PortfolioColors = darkColorScheme(
    primary = Primary,
    onPrimary = DeepNight,
    secondary = Secondary,
    onSecondary = DeepNight,
    tertiary = Tertiary,
    background = DeepNight,
    surface = Glass,
    onSurface = Ink,
    onSurfaceVariant = MutedInk,
    outline = ColorOutline
)

@Composable
fun PortfolioTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = PortfolioColors, typography = AppTypography, content = content)
}
