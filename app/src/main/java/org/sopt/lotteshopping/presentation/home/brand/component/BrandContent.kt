package org.sopt.lotteshopping.presentation.home.brand.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.core.extension.noRippleClickable

@Composable
fun BrandContent(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onBrandNewsClick: () -> Unit = {},
    onReviewClick: () -> Unit = {},
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(LotteTheme.colors.white),
    ) {
        stickyHeader {
            BrandHeader(
                onBackClick = onBackClick,
                onHomeClick = onHomeClick,
                onShareClick = onShareClick,
            )
        }

        item {
            BrandBannerHeader(
                imageRes = R.drawable.img_sulwhasoo_banner_header,
            )
        }

        item {
            BrandInfoContainer(
                floor = "B1 화장품",
                brandName = "설화수",
                description = "전통의 지혜에서 영감을 받아 현대의 고유한 솔루션을 만드는 아모레퍼시픽의 한방 화장품 브랜드",
            )
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 24.dp,
                    ),
                verticalArrangement = Arrangement.spacedBy(24.dp),
            ) {
                ReservationCard(
                    title = "[설화수] 스킨케어 컨설팅 서비스",
                    period = "04.01 (수) ~ 4.30 (목)",
                )

                BrandServiceContent(
                    services = brandServices,
                )

                DiscountInformationSection()

                BrandBanner(
                    brandName = "비오템",
                )
            }
        }

        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(LotteTheme.colors.gray50),
            )
        }

        item {
            BrandCouponSection(
                onBrandNewsClick = onBrandNewsClick,
                onReviewClick = onReviewClick,
            )
        }
    }
}

@Composable
private fun DiscountInformationSection(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "쿠폰·에누리 적용 가능 할인율: 최대 10%",
            color = LotteTheme.colors.black,
            style = LotteTheme.typography.body.sb16,
        )

        InformationCard()
    }
}

@Composable
private fun BrandHeader(
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.background(LotteTheme.colors.white),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 12.dp,
                    vertical = 10.dp,
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BrandHeaderIconButton(
                iconRes = R.drawable.ic_header_arrow,
                onClick = onBackClick,
            )

            Row {
                BrandHeaderIconButton(
                    iconRes = R.drawable.ic_header_home,
                    onClick = onHomeClick,
                )
                BrandHeaderIconButton(
                    iconRes = R.drawable.ic_header_share,
                    onClick = onShareClick,
                )
            }
        }
        HorizontalDivider(
            thickness = 0.5.dp,
            color = LotteTheme.colors.gray100,
        )
    }
}

@Composable
private fun BrandHeaderIconButton(
    iconRes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .noRippleClickable(onClick)
            .size(36.dp),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(iconRes),
            contentDescription = null,
            tint = LotteTheme.colors.black,
            modifier = Modifier.size(24.dp),
        )
    }
}

@Composable
private fun BrandCouponSection(
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

private val brandServices = listOf(
    BrandService(
        iconRes = R.drawable.ic_brand_papervoucher,
        label = "지류 상품권",
    ),
    BrandService(
        iconRes = R.drawable.ic_brand_mobilevoucher,
        label = "모바일 상품권",
    ),
    BrandService(
        iconRes = R.drawable.ic_brand_lpoint,
        label = "L. POINT",
    ),
    BrandService(
        iconRes = R.drawable.ic_brand_pet,
        label = "반려동물 동반",
    ),
)

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    widthDp = 360,
    heightDp = 1600,
)
@Composable
private fun BrandContentPreview() {
    LOTTESHOPPINGTheme {
        BrandContent()
    }
}
