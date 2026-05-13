package org.sopt.lotteshopping.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.core.designsystem.component.UrlImage
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.data.HomePreferenceModel


@Composable
fun HomePreferenceSection(
    preferenceItems: List<HomePreferenceModel>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(LotteTheme.colors.black)
    )
    {
        Text(
            modifier = Modifier
                .padding(top = 24.dp, start = 14.dp),
            text = "취향 확장",
            color = LotteTheme.colors.white,
            style = LotteTheme.typography.title.sb18
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            modifier = Modifier
                .padding(start = 14.dp),
            text = "나의 세계를 넓히는 감각적인 제안",
            color = LotteTheme.colors.gray300,
            style = LotteTheme.typography.body.r14
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 14.dp)
        ) {

            items(preferenceItems) { item ->
                HomePreferenceCard(
                    imageUrl = item.imageUrl,
                    title = item.title,
                    targetBranch = item.targetBranch,
                    startDate = item.startDate,
                    endDate = item.endDate
                )
            }
        }
    }

}

@Composable
private fun HomePreferenceCard(
    imageUrl: String,
    title: String,
    targetBranch: String,
    startDate: String,
    endDate: String,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .width(240.dp)
            .background(LotteTheme.colors.white)
            .padding(top = 14.dp, bottom = 24.dp)
    )
    {
        UrlImage(
            url = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(212.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 14.dp),
            style = LotteTheme.typography.body.m14,
            color = LotteTheme.colors.black
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 14.dp),
            text = targetBranch,
            style = LotteTheme.typography.label.r12,
            color = LotteTheme.colors.gray400
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            modifier = Modifier.padding(horizontal = 14.dp),
            text = "$startDate ~ $endDate",
            style = LotteTheme.typography.label.r12,
            color = LotteTheme.colors.gray400
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun HomePreferenceSectionPreview() {
    HomePreferenceSection(preferenceItems = emptyList())
}