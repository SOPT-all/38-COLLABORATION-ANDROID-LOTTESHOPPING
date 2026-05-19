package org.sopt.lotteshopping.presentation.home.brand.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme

@Composable
fun BrandCouponSection(
    onBrandNewsClick: () -> Unit,
    onReviewClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    top = 14.dp,
                ),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            UnderlineTab(
                label = "브랜드 뉴스",
                selected = true,
                onClick = onBrandNewsClick,
            )
            UnderlineTab(
                label = "리뷰",
                selected = false,
                onClick = onReviewClick,
            )
        }
        HorizontalDivider(
            thickness = 0.4.dp,
            color = LotteTheme.colors.gray200,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = "쿠폰",
                modifier = Modifier.padding(horizontal = 20.dp),
                color = LotteTheme.colors.black,
                style = LotteTheme.typography.title.sb18,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                ProductCard(
                    imageRes = R.drawable.img_brand_coupon_1,
                    title = "[뷰티] 7.5~10% 상품 금액할인권",
                    date = "4.23(목) ~ 5.6(수)",
                    modifier = Modifier.weight(1f),
                )
                ProductCard(
                    imageRes = R.drawable.img_brand_coupon_2,
                    title = "[뷰티] 10만원 이상 구매시 1.5만원 금액할인권",
                    date = "5.1(금) ~ 5.31(일)",
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}
