package org.sopt.lotteshopping.presentation.home.brand.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme

@Composable
fun ProductCard(
    title: String,
    date: String,
    modifier: Modifier = Modifier,
    showAllStoreBadge: Boolean = true,
    allStoreBadgeLabel: String = "백화점 전점",
) {
    Column(
        modifier = modifier.width(155.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Box(
            modifier = Modifier
                .size(155.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(LotteTheme.colors.gray50),
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = title,
                color = LotteTheme.colors.black,
                style = LotteTheme.typography.body.m14,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = date,
                    color = LotteTheme.colors.gray400,
                    style = LotteTheme.typography.caption.r10,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                if (showAllStoreBadge) {
                    AllStoreBadge(label = allStoreBadgeLabel)
                }
            }
        }
    }
}

@Composable
private fun AllStoreBadge(
    label: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = label,
        modifier = modifier
            .clip(RoundedCornerShape(99.dp))
            .background(LotteTheme.colors.lime500)
            .padding(
                horizontal = 6.dp,
                vertical = 2.dp,
            ),
        color = LotteTheme.colors.black,
        style = LotteTheme.typography.caption.r10,
        maxLines = 1,
        overflow = TextOverflow.Clip,
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    widthDp = 155,
    heightDp = 241,
)
@Composable
private fun ProductCardPreview() {
    LOTTESHOPPINGTheme {
        ProductCard(
            title = "[뷰티] 7.5~10% 금액할인권",
            date = "4.23(목) ~ 5.6(수)",
        )
    }
}
