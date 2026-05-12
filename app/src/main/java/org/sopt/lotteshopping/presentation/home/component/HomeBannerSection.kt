package org.sopt.lotteshopping.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.data.bannerItems


@Composable
fun HomeBannerSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(LotteTheme.colors.black)
            .wrapContentHeight()
    )
    {
        Text(
            modifier = Modifier
                .padding(top = 24.dp, bottom = 4.dp)
                .padding(start = 14.dp),
            text = "취향 확장",
            color = LotteTheme.colors.white,
            style = LotteTheme.typography.title.sb18

        )

        Text(
            modifier = Modifier
                .padding(start = 14.dp)
                .padding(top = 4.dp),
            text = "나의 세계를 넓히는 감각적인 제안",
            color = LotteTheme.colors.gray300,
            style = LotteTheme.typography.body.r14
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 14.dp)
        ) {

            items(bannerItems) { item ->
                BannerCard(
                    imageRes = item.imageRes,
                    title = item.title,
                    location = item.location,
                    date = item.date
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeBannerSectionPreview() {
    HomeBannerSection()
}