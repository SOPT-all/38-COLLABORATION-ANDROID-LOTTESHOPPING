package org.sopt.lotteshopping.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalLotteColors = staticCompositionLocalOf { defaultLotteColors }

private val LotteColorScheme = lightColorScheme(
    primary = defaultLotteColors.lime500,
    secondary = defaultLotteColors.blue500,
    tertiary = defaultLotteColors.orangeGradientStart,
    background = defaultLotteColors.common100,
    surface = defaultLotteColors.common100,
    onPrimary = defaultLotteColors.common0,
    onSecondary = defaultLotteColors.common100,
    onTertiary = defaultLotteColors.common100,
    onBackground = defaultLotteColors.common0,
    onSurface = defaultLotteColors.common0,
)

object LotteTheme {
    val colors: LotteColors
        @Composable
        @ReadOnlyComposable
        get() = LocalLotteColors.current
}

@Composable
fun ProvideLotteColors(
    colors: LotteColors = defaultLotteColors,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalLotteColors provides colors,
        content = content,
    )
}

@Composable
fun LOTTESHOPPINGTheme(
    content: @Composable () -> Unit,
) {
    ProvideLotteColors {
        MaterialTheme(
            colorScheme = LotteColorScheme,
            typography = Typography,
            content = content,
        )
    }
}
