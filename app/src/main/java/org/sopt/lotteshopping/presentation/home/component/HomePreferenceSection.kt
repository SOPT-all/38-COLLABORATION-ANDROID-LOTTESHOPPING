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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.component.UrlImage
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.data.model.preferences.HomePreferenceModel


@Composable
fun HomePreferenceSection(
    preferenceItems: List<HomePreferenceModel>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(LotteTheme.colors.black)
            .padding(top = 24.dp, bottom = 20.dp),
    ) {
        Text(
            modifier = Modifier.padding(start = 14.dp),
            text = "취향 확장",
            color = LotteTheme.colors.white,
            style = LotteTheme.typography.title.sb18
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            modifier = Modifier.padding(start = 14.dp),
            text = "나의 세계를 넓히는 감각적인 제안",
            color = LotteTheme.colors.gray300,
            style = LotteTheme.typography.body.r14
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 14.dp)
        ) {
            items(preferenceItems) { preferenceItem ->
                HomePreferenceCardItem(
                    preference = preferenceItem,
                )
            }
        }
    }
}


@Composable
private fun HomePreferenceCardItem(
    preference: HomePreferenceModel,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .background(LotteTheme.colors.white)
            .padding(horizontal = 14.dp)
            .padding(top = 14.dp, bottom = 24.dp)
    ) {
        UrlImage(
            url = preference.imageUrl,
            contentDescription = null,
            modifier = Modifier.size(212.dp),
            placeholderDrawable = R.drawable.ic_launcher_background,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = preference.title,
            style = LotteTheme.typography.body.m14,
            color = LotteTheme.colors.black
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier,
            text = preference.targetBranch,
            style = LotteTheme.typography.label.r12,
            color = LotteTheme.colors.gray400
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "${preference.startDate} ~ ${preference.endDate}",
            style = LotteTheme.typography.label.r12,
            color = LotteTheme.colors.gray400
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun HomePreferenceSectionPreview() {
    LOTTESHOPPINGTheme {
        HomePreferenceSection(
            preferenceItems = listOf(
                HomePreferenceModel(
                    imageUrl = "",
                    title = "[브랜드 읽기] Chanel의 No.5",
                    targetBranch = "전점",
                    startDate = "4.1(수)",
                    endDate = "12.31(동)",
                    id = 0,
                ),
                HomePreferenceModel(
                    imageUrl = "",
                    title = "[스테디셀러] Clinique 기획전",
                    targetBranch = "전점",
                    startDate = "4.1(수)",
                    endDate = "12.31(목)",
                    id = 1,
                ),
            )
        )
    }
}
