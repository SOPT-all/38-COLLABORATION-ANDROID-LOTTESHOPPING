package org.sopt.lotteshopping.presentation.shopping.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.component.UrlImage
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.data.model.shopping.NewsModel

@Composable
fun ShoppingCardProduct(
    news: NewsModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        UrlImage(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .aspectRatio(1f),
            url = news.imageUrl,
            placeholderDrawable = R.drawable.ic_launcher_background,
            contentScale = ContentScale.Crop,
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = news.title,
            color = LotteTheme.colors.black,
            style = LotteTheme.typography.body.m14,
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = "${news.startDate} ~ ${news.endDate}",
            color = LotteTheme.colors.gray400,
            style = LotteTheme.typography.caption.r10,
        )

        if (news.hasTargetBranch) {
            Spacer(Modifier.height(4.dp))

            NewsBadge(
                label = news.targetBranch,
            )
        }
    }
}

@Composable
private fun NewsBadge(
    label: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = label,
        modifier = modifier
            .background(
                color = LotteTheme.colors.lime500,
                shape = CircleShape
            )
            .padding(horizontal = 6.dp, vertical = 2.dp),
        color = LotteTheme.colors.black,
        style = LotteTheme.typography.caption.r10,
    )
}

private class ShoppingCardProductPreviewProvider : PreviewParameterProvider<NewsModel> {
    override val values: Sequence<NewsModel>
        get() = sequenceOf(
            NewsModel(
                id = 0L,
                title = "[뷰티] 7.5~10% 금액할인권",
                targetBranch = "백화점 전점",
                startDate = "4.23(목)",
                endDate = "5.6(수)",
                imageUrl = ""
            ),
            NewsModel(
                id = 1L,
                title = "[MLB 키즈] 2026 럭키 페스타 개최",
                targetBranch = "",
                startDate = "4.15(수)",
                endDate = "5.27(수)",
                imageUrl = ""
            ),
        )
}

@Preview(showBackground = true, widthDp = 155)
@Composable
private fun ShoppingCardProductPreview(
    @PreviewParameter(ShoppingCardProductPreviewProvider::class) news: NewsModel,
) {
    LOTTESHOPPINGTheme {
        ShoppingCardProduct(
            news = news,
            modifier = Modifier.padding(all = 8.dp),
        )
    }
}
