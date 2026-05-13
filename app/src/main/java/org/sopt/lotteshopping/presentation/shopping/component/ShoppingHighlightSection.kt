package org.sopt.lotteshopping.presentation.shopping.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.component.UrlImage
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.data.model.info.HighlightModel

@Composable
fun ShoppingHighlightSection(
    highlights: List<HighlightModel>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 6.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(items = highlights, key = { it.id }) { banner ->
                UrlImage(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .width(300.dp)
                        .aspectRatio(300f/250f),
                    url = banner.imageUrl,
                    placeholderDrawable = R.drawable.ic_launcher_background,
                    contentScale = ContentScale.Crop,
                )
            }
        }

        ActionButton(modifier = Modifier.padding(end = 20.dp))
    }
}

@Composable
private fun ActionButton(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "하이라이트 더보기",
            color = LotteTheme.colors.gray600,
            style = LotteTheme.typography.label.m12,
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_chevron_right),
            contentDescription = null,
            tint = LotteTheme.colors.gray600,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShoppingHighlightSectionPreview() {
    LOTTESHOPPINGTheme {
        ShoppingHighlightSection(
            highlights = listOf(
                HighlightModel(
                    id = 1L,
                    imageUrl = ""
                ),
                HighlightModel(
                    id = 2L,
                    imageUrl = ""
                ),
                HighlightModel(
                    id = 3L,
                    imageUrl = ""
                ),
                HighlightModel(
                    id = 4L,
                    imageUrl = ""
                ),
                HighlightModel(
                    id = 5L,
                    imageUrl = ""
                ),
            ),
        )
    }
}
