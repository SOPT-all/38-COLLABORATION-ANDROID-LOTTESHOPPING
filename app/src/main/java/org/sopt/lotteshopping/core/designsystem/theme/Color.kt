package org.sopt.lotteshopping.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Immutable
data class LotteColors(
    val lime500: Color,
    val blue500: Color,
    val orangeGradientStart: Color,
    val orangeGradientEnd: Color,
    val gray50: Color,
    val gray100: Color,
    val gray200: Color,
    val gray300: Color,
    val gray400: Color,
    val gray500: Color,
    val gray600: Color,
    val gray700: Color,
    val white: Color,
    val black: Color,
) {
    val orangeGradient: Brush
        get() = Brush.horizontalGradient(
            colors = listOf(orangeGradientEnd, orangeGradientStart),
        )
}

val defaultLotteColors = LotteColors(
    lime500 = Color(0xFFDAF631),
    blue500 = Color(0xFF008DFF),
    orangeGradientStart = Color(0xFFFB8408),
    orangeGradientEnd = Color(0xFFFE6501),
    gray50 = Color(0xFFF5F6F6),
    gray100 = Color(0xFFECEDED),
    gray200 = Color(0xFFD9D9D9),
    gray300 = Color(0xFFBFBFBF),
    gray400 = Color(0xFF797979),
    gray500 = Color(0xFF666666),
    gray600 = Color(0xFF434343),
    gray700 = Color(0xFF1F1B1A),
    white = Color(0xFFFFFFFF),
    black = Color(0xFF000000),
)
