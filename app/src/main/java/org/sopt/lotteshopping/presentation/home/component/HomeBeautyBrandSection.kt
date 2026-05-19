package org.sopt.lotteshopping.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.component.UrlImage
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.colors
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.typography
import org.sopt.lotteshopping.core.extension.noRippleClickable
import org.sopt.lotteshopping.data.model.brands.HomeBeautyBrandModel
@Composable
fun HomeBeautyBrandSection(
    brands: List<HomeBeautyBrandModel>,
    onBrandClick: (HomeBeautyBrandModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "이 뷰티 브랜드 어때요?",
            modifier = Modifier.padding(start = 20.dp),
            style = typography.body.m16,
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 20.dp),
        ) {
            items(brands) { brand ->
                HomeBeautyBrandCircleItem(
                    beauty = brand,
                    onBrandClick = onBrandClick
                )
            }
        }
    }
}

@Composable
private fun HomeBeautyBrandCircleItem(
    beauty: HomeBeautyBrandModel,
    onBrandClick: (HomeBeautyBrandModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.noRippleClickable { onBrandClick(beauty) },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .size(54.dp)
                .background(
                    color = colors.white,
                    shape = CircleShape,
                )
                .clip(CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            UrlImage(
                url = beauty.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(7.dp),
                placeholderDrawable = R.drawable.ic_launcher_background,
                contentScale = ContentScale.Fit,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = beauty.name,
            color = colors.gray500,
            style = typography.label.m12,
            textAlign = TextAlign.Center,
        )
    }
}


@Preview(showBackground = true, backgroundColor = 0XFFECEDED)
@Composable
private fun HomeBeautyBrandSectionPreview() {
    LOTTESHOPPINGTheme {
        val mockBrands = listOf(
            HomeBeautyBrandModel(1L, "클리니크", ""),
            HomeBeautyBrandModel(2L, "설화수", ""),
            HomeBeautyBrandModel(3L, "라네즈", ""),
            HomeBeautyBrandModel(4L, "키엘", ""),
            HomeBeautyBrandModel(5L, "나스", ""),
            HomeBeautyBrandModel(6L, "나", ""),
            HomeBeautyBrandModel(7L, "스", "")
        )
        HomeBeautyBrandSection(
            brands = mockBrands,
            onBrandClick = {}
        )
    }
}
