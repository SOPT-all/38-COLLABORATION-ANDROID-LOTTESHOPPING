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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
            ColorPreviewItem("orangeGradientStart", LotteTheme.colors.orangeGradientStart)
            ColorPreviewItem("orangeGradientEnd", LotteTheme.colors.orangeGradientEnd)
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

@Preview(showBackground = true)
@Composable
private fun LotteTypographyPreview() {
    LOTTESHOPPINGTheme {
        Column(
            modifier = Modifier
                .background(LotteTheme.colors.white)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text("Display B30", style = LotteTheme.typography.display.b30)
            Text("Title SB18", style = LotteTheme.typography.title.sb18)
            Text("Title M18", style = LotteTheme.typography.title.m18)
            Text("Title R18", style = LotteTheme.typography.title.r18)
            Text("Body SB16", style = LotteTheme.typography.body.sb16)
            Text("Body M16", style = LotteTheme.typography.body.m16)
            Text("Body R16", style = LotteTheme.typography.body.r16)
            Text("Body SB14", style = LotteTheme.typography.body.sb14)
            Text("Body M14", style = LotteTheme.typography.body.m14)
            Text("Body R14", style = LotteTheme.typography.body.r14)
            Text("Label M12", style = LotteTheme.typography.label.m12)
            Text("Label R12", style = LotteTheme.typography.label.r12)
            Text("Caption R10", style = LotteTheme.typography.caption.r10)
        }
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
