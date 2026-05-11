package org.sopt.lotteshopping.core.designsystem.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Immutable
data class LotteColors(
    val lime500: Color,
    val blue500: Color,
    val orangeGradient: Brush,
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
)

val defaultLotteColors = LotteColors(
    lime500 = Color(0xFFDAF631),
    blue500 = Color(0xFF008DFF),
    orangeGradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFFFE6501), Color(0xFFFB8408)),
    ),
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

@Preview(showBackground = true)
@Composable
private fun LotteColorPreview() {
    LOTTESHOPPINGTheme {
        Column(
            modifier = Modifier
                .background(LotteTheme.colors.white)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            ColorPreviewItem("lime500", LotteTheme.colors.lime500)
            ColorPreviewItem("blue500", LotteTheme.colors.blue500)
            GradientPreviewItem("orangeGradient", LotteTheme.colors.orangeGradient)
            ColorPreviewItem("gray50", LotteTheme.colors.gray50)
            ColorPreviewItem("gray100", LotteTheme.colors.gray100)
            ColorPreviewItem("gray200", LotteTheme.colors.gray200)
            ColorPreviewItem("gray300", LotteTheme.colors.gray300)
            ColorPreviewItem("gray400", LotteTheme.colors.gray400)
            ColorPreviewItem("gray500", LotteTheme.colors.gray500)
            ColorPreviewItem("gray600", LotteTheme.colors.gray600)
            ColorPreviewItem("gray700", LotteTheme.colors.gray700)
            ColorPreviewItem("white", LotteTheme.colors.white)
            ColorPreviewItem("black", LotteTheme.colors.black)
        }
    }
}

@Composable
private fun GradientPreviewItem(
    name: String,
    brush: Brush,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(brush),
        )
        Text(
            text = name,
            style = LotteTheme.typography.body.m14,
            color = LotteTheme.colors.black,
        )
    }
}

@Composable
private fun ColorPreviewItem(
    name: String,
    color: Color,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(color),
        )
        Text(
            text = name,
            style = LotteTheme.typography.body.m14,
            color = LotteTheme.colors.black,
        )
    }
}
