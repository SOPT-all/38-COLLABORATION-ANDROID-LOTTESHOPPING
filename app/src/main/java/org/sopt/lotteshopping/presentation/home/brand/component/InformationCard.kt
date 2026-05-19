package org.sopt.lotteshopping.presentation.home.brand.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme

@Composable
fun InformationCard(
    modifier: Modifier = Modifier,
    noticeTitle: String = "꼭 확인해주세요!",
    primaryDescription: String = "쿠폰·에누리 등을 통해 최대로 적용 받으실 수 있는 할인율 기준으로, 고객님께서 사용 가능한 할인 수단에 따라 할인율이 다르게 적용됩니다.",
    descriptions: List<String> = listOf(
        "정상 상품에 한하여 할인 적용이 가능합니다.",
        "행사 상품 등 일부 상품은 할인이 불가하거나 할인율이 상이할 수 있습니다.",
    ),
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = LotteTheme.colors.gray50,
                shape = RoundedCornerShape(12.dp),
            )
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            InfoBadge()
            Text(
                text = noticeTitle,
                color = LotteTheme.colors.black,
                style = LotteTheme.typography.body.m14,
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            InformationText(
                text = primaryDescription,
                color = LotteTheme.colors.black,
                style = LotteTheme.typography.label.m12,
            )

            descriptions.forEach { description ->
                InformationText(
                    text = description,
                    color = LotteTheme.colors.gray500,
                    style = LotteTheme.typography.label.r12,
                )
            }
        }
    }
}

@Composable
private fun InfoBadge(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(R.drawable.ic_info_badge),
        contentDescription = null,
        modifier = modifier
            .size(14.dp),
    )
}

@Composable
private fun InformationText(
    text: String,
    color: Color,
    style: TextStyle,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalAlignment = Alignment.Top,
    ) {
        Text(
            text = "•",
            color = color,
            style = style,
        )
        Text(
            text = text,
            modifier = Modifier.weight(1f),
            color = color,
            style = style,
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    widthDp = 320,
)
@Composable
private fun InformationCardPreview() {
    LOTTESHOPPINGTheme {
        InformationCard()
    }
}
