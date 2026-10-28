package com.madhupatel.portfolio.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AppTypography = Typography(
    headlineLarge = TextStyle(FontFamily.Default, FontWeight.Bold, 34.sp, lineHeight = 40.sp),
    headlineMedium = TextStyle(FontFamily.Default, FontWeight.Bold, 28.sp, lineHeight = 34.sp),
    titleLarge = TextStyle(FontFamily.Default, FontWeight.SemiBold, 20.sp, lineHeight = 26.sp),
    titleMedium = TextStyle(FontFamily.Default, FontWeight.Medium, 16.sp, lineHeight = 22.sp),
    bodyLarge = TextStyle(FontFamily.Default, FontWeight.Normal, 16.sp, lineHeight = 24.sp),
    bodyMedium = TextStyle(FontFamily.Default, FontWeight.Normal, 14.sp, lineHeight = 20.sp),
    labelMedium = TextStyle(FontFamily.Default, FontWeight.Medium, 12.sp, letterSpacing = 1.2.sp)
)
