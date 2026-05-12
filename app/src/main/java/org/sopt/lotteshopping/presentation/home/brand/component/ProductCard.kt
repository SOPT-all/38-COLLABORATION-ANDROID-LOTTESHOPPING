package org.sopt.lotteshopping.presentation.home.brand.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme

@Composable
fun ProductCard(
    @DrawableRes imageRes: Int,
    title: String,
    date: String,
    modifier: Modifier = Modifier,
    showAllStoreBadge: Boolean = true,
    allStoreBadgeLabel: String = "백화점 전점",
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(4.dp)),
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

@Composable
private fun AllStoreBadge(
    label: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = label,
        modifier = modifier
            .background(
                color = LotteTheme.colors.lime500,
                shape = CircleShape,
            )
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
            imageRes = R.drawable.ic_launcher_background,
            title = "[뷰티] 7.5~10% 금액할인권",
            date = "4.23(목) ~ 5.6(수)",
            modifier = Modifier.width(155.dp),
        )
    }
}
