package org.sopt.lotteshopping.presentation.home.brand.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme

@Immutable
data class BrandService(
    @param:DrawableRes val iconRes: Int,
    val label: String,
)

@Composable
fun BrandServiceContent(
    services: List<BrandService>,
    modifier: Modifier = Modifier,
    title: String = "이용 가능 서비스",
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = title,
            color = LotteTheme.colors.black,
            style = LotteTheme.typography.body.sb16,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(22.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            services.forEach { service ->
                Tile(
                    iconRes = service.iconRes,
                    label = service.label,
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    widthDp = 320,
)
@Composable
private fun BrandServiceContentPreview() {
    LOTTESHOPPINGTheme {
        BrandServiceContent(
            services = listOf(
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
            ),
        )
    }
}
