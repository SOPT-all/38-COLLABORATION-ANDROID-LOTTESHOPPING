package org.sopt.lotteshopping.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.colors
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.typography
import org.sopt.lotteshopping.core.extension.noRippleClickable
import org.sopt.lotteshopping.data.model.brands.BeautyContentModel


enum class HomeStoreTab(val title: String) {
    DEPARTMENT_STORE("백화점"),
    AVENUEL("에비뉴엘")
}


@Composable
fun HomeBeautyContentSection(
    contents: List<BeautyContentModel>,
    selectedTab: HomeStoreTab,
    onTabClick: (HomeStoreTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(colors.white)
            .padding(horizontal = 16.dp)
            .padding(top = 18.dp, bottom = 24.dp)
    ) {
        Text(text = "나만을 위한 뷰티 컬렉션", style = typography.title.sb18)

        Spacer(modifier = Modifier.height(12.dp))

        HomeBeautyContentTab(
            selectedTab = selectedTab,
            onTabClick = onTabClick,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            contents.chunked(2).forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    rowItems.forEach { item ->
                        HomeBeautyContentCard(
                            imageRes = item.imageRes,
                            title = item.brandName,
                            subTitle = item.description,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun HomeBeautyContentTabItem(
    tab: HomeStoreTab,
    isSelected: Boolean,
    onTabClick: (HomeStoreTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(
                color = if (isSelected) colors.black else colors.white,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .noRippleClickable { onTabClick(tab) }
            .padding(horizontal = 8.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = tab.title,
            style = typography.body.sb14,
            color = if (isSelected) colors.white else colors.gray300
        )
    }
}

@Composable
private fun HomeBeautyContentTab(
    selectedTab: HomeStoreTab,
    onTabClick: (HomeStoreTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        HomeStoreTab.entries.forEach { tab ->
            HomeBeautyContentTabItem(
                tab = tab,
                isSelected = tab == selectedTab,
                onTabClick = onTabClick,
            )
        }
    }
}

@Composable
private fun HomeBeautyContentCard(
    @DrawableRes imageRes: Int,
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .aspectRatio(1f),
            contentScale = ContentScale.Crop,
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = "$title\n$subTitle",
            color = colors.black,
            style = typography.body.m14,
        )
    }
}




@Preview
@Composable
private fun HomeBeautyContentSectionPreview(
) {
    LOTTESHOPPINGTheme {
        var selectedTab by remember { mutableStateOf(HomeStoreTab.DEPARTMENT_STORE) }

        val mockContents = listOf(
            BeautyContentModel(R.drawable.img_home_collection_aesop, "[Aesop]", "감각적인 데일리 케어"),
            BeautyContentModel(
                R.drawable.img_home_collection_sulwhasoo,
                "[Sulwhasoo]",
                "윤빛 케어 에센셜"
            ),
            BeautyContentModel(R.drawable.img_home_collection_kiehls, "[Kiehl's]", "가정의달 프로모션"),
            BeautyContentModel(R.drawable.img_home_collection_sk2, "[SK-II]", "FESTA 특별 이벤트")
        )

        HomeBeautyContentSection(
            contents = mockContents,
            selectedTab = selectedTab,
            onTabClick = { selectedTab = it }
        )
    }
}
