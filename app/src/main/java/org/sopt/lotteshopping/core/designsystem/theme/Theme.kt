package org.sopt.lotteshopping.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalLotteColors = staticCompositionLocalOf { defaultLotteColors }
private val LocalLotteTypography = staticCompositionLocalOf { defaultLotteTypography }
private val LocalLotteGrid = staticCompositionLocalOf { defaultLotteGrid }

private val LotteColorScheme = lightColorScheme(
    primary = defaultLotteColors.lime500,
    secondary = defaultLotteColors.blue500,
    tertiary = defaultLotteColors.orangeGradientStart,
    background = defaultLotteColors.white,
    surface = defaultLotteColors.white,
    onPrimary = defaultLotteColors.black,
    onSecondary = defaultLotteColors.white,
    onTertiary = defaultLotteColors.white,
    onBackground = defaultLotteColors.black,
    onSurface = defaultLotteColors.black,
)

object LotteTheme {
    val colors: LotteColors
        @Composable
        @ReadOnlyComposable
        get() = LocalLotteColors.current

    val typography: LotteTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalLotteTypography.current

    val grid: LotteGrid
        @Composable
        @ReadOnlyComposable
        get() = LocalLotteGrid.current
}

@Composable
fun ProvideLotteDesignTokens(
    colors: LotteColors = defaultLotteColors,
    typography: LotteTypography = defaultLotteTypography,
    grid: LotteGrid = defaultLotteGrid,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalLotteColors provides colors,
        LocalLotteTypography provides typography,
        LocalLotteGrid provides grid,
        content = content,
    )
}

@Composable
fun LOTTESHOPPINGTheme(
    content: @Composable () -> Unit,
) {
    ProvideLotteDesignTokens {
        MaterialTheme(
            colorScheme = LotteColorScheme,
            typography = defaultMaterialTypography,
            content = content,
        )
    }
}
