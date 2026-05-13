package org.sopt.lotteshopping.presentation.shopping.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme

private val tabLabels = listOf("쇼핑뉴스", "사은", "문화/이벤트")

@Composable
fun ShoppingUnderlineTabContainer(
    modifier: Modifier = Modifier,
) {
    val colors = LotteTheme.colors

    Row(
        modifier = modifier
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = 0.4.dp.toPx()
                val y = size.height + strokeWidth / 2

                drawLine(
                    color = colors.gray200,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth,
                )
            }
            .padding(start = 24.dp, top = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        tabLabels.forEachIndexed { index, label ->
            UnderlineTab(
                label = label,
                selected = index == 0,
            )
        }
    }
}

@Composable
private fun UnderlineTab(
    label: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
) {
    val colors = LotteTheme.colors

    Text(
        text = label,
        modifier = modifier
            .padding(bottom = if (selected) 10.dp else 12.dp)
            .drawBehind {
                if (!selected) return@drawBehind

                val strokeWidth = 2.dp.toPx()
                val y = size.height + strokeWidth / 2 + 10.dp.toPx()

                drawLine(
                    color = colors.black,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth,
                )
            },
        color = if (selected) colors.black else colors.gray300,
        style = LotteTheme.typography.body.m14,
    )
}

@Preview(showBackground = true)
@Composable
private fun ShoppingUnderlineTabContainerPreview() {
    LOTTESHOPPINGTheme {
        ShoppingUnderlineTabContainer(
            modifier = Modifier.padding(vertical = 20.dp)
        )
    }
}
