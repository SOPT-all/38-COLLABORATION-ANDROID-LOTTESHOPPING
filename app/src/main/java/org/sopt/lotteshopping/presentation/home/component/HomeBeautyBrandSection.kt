package org.sopt.lotteshopping.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import org.sopt.lotteshopping.data.model.brands.BeautyBrandModel

@Composable
private fun HomeBeautyBrandCircleItem(
    beauty: BeautyBrandModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
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
            maxLines = 1,
        )
    }
}

@Composable
fun HomeBeautyBrandSection(
    brands: List<BeautyBrandModel>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "이 뷰티 브랜드 어때요?",
            style = typography.body.m16,
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(brands) { brand ->
                HomeBeautyBrandCircleItem(
                    beauty = brand,
                )
            }
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0XFFECEDED)
@Composable
private fun HomeBeautyBrandSectionPreview() {
    LOTTESHOPPINGTheme {
        val mockBrands = listOf(
            BeautyBrandModel(1L, "클리니크", ""),
            BeautyBrandModel(2L, "설화수", ""),
            BeautyBrandModel(3L, "라네즈", ""),
            BeautyBrandModel(4L, "키엘", ""),
            BeautyBrandModel(5L, "나스", ""),
            BeautyBrandModel(6L, "나", ""),
            BeautyBrandModel(7L, "스", "")
        )
        HomeBeautyBrandSection(brands = mockBrands)
    }
}
