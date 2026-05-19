package org.sopt.lotteshopping.presentation.home.brand

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.presentation.home.brand.component.BrandBanner
import org.sopt.lotteshopping.presentation.home.brand.component.BrandBannerHeader
import org.sopt.lotteshopping.presentation.home.brand.component.BrandCouponSection
import org.sopt.lotteshopping.presentation.home.brand.component.BrandHeader
import org.sopt.lotteshopping.presentation.home.brand.component.BrandInfoContainer
import org.sopt.lotteshopping.presentation.home.brand.component.BrandService
import org.sopt.lotteshopping.presentation.home.brand.component.BrandServiceContent
import org.sopt.lotteshopping.presentation.home.brand.component.DiscountInformationSection
import org.sopt.lotteshopping.presentation.home.brand.component.ReservationCard

@Composable
fun BrandRoute(
    innerPadding: PaddingValues,
    navigateUp: () -> Unit,
    navigateHome:()->Unit,
) {
    BrandScreen(
        onBackClick = navigateUp,
        onHomeClick = navigateHome,
        modifier = Modifier.padding(innerPadding),
    )
}

@Composable
fun BrandScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
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
private fun BrandScreenPreview() {
    LOTTESHOPPINGTheme {
        BrandScreen(
            onBackClick = {},
        )
    }
}
