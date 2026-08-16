package com.example.fitme.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object FitMeColors {
    // Primary Blue Palette
    val BluePrimary = Color(0xFF0B47BE)
    val BlueLight = Color(0xFF0084FF)
    val BlueDark = Color(0xFF061A56)
    val BlueBackground = Color(0xFFEBF3FF)

    // Primary Magenta / Pink Palette
    val MagentaPrimary = Color(0xFFE01A76)
    val MagentaLight = Color(0xFFFA2A85)
    val MagentaDark = Color(0xFF7C179B)
    val MagentaBackground = Color(0xFFFFF0F6)

    // Neutral Colors
    val BackgroundLight = Color(0xFFF9FAFC)
    val CardBackground = Color(0xFFFFFFFF)
    val TextPrimary = Color(0xFF1E293B)
    val TextSecondary = Color(0xFF64748B)
    val TextMuted = Color(0xFF94A3B8)
    val BorderLight = Color(0xFFE2E8F0)

    // Gradients
    val PrimaryGradient = Brush.horizontalGradient(
        colors = listOf(MagentaDark, MagentaPrimary, MagentaLight)
    )

    val BlueGradient = Brush.linearGradient(
        colors = listOf(BlueDark, BluePrimary, BlueLight)
    )

    val PinkGradient = Brush.linearGradient(
        colors = listOf(MagentaDark, MagentaPrimary, MagentaLight)
    )

    val SubtitleBlueGradient = Color(0xFF1565C0)
    val SubtitlePinkGradient = Color(0xFFE91E63)

    val CardSelectedBorder = MagentaPrimary
    val CardUnselectedBorder = Color(0xFFE2E8F0)
}
