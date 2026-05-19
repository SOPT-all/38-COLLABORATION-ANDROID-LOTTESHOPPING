package org.sopt.lotteshopping.presentation.home.brand.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

@Composable
fun BrandInfoContainer(
    floor: String,
    brandName: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 24.dp,
                ),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            BrandTitle(
                floor = floor,
                brandName = brandName,
            )

            Text(
                text = description,
                color = LotteTheme.colors.black,
                style = LotteTheme.typography.body.r14,
            )
        }

        BrandMenuBar()
    }
}

@Composable
private fun BrandTitle(
    floor: String,
    brandName: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = floor,
            color = LotteTheme.colors.gray400,
            style = LotteTheme.typography.body.m14,
        )
        Text(
            text = brandName,
            color = LotteTheme.colors.black,
            style = LotteTheme.typography.display.b30,
        )
    }
}

@Composable
private fun BrandMenuBar(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        HorizontalDivider(
            thickness = 0.5.dp,
            color = LotteTheme.colors.gray200,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BrandMenuItem(
                iconRes = R.drawable.ic_brand_call,
                label = "전화",
                modifier = Modifier.weight(1f),
            )
            BrandMenuItem(
                iconRes = R.drawable.ic_brand_map,
                label = "쇼핑맵",
                modifier = Modifier.weight(1f),
            )
            BrandMenuItem(
                iconRes = R.drawable.ic_brand_fan,
                label = "FAN설정",
                modifier = Modifier.weight(1f),
            )
        }
        HorizontalDivider(
            thickness = 0.5.dp,
            color = LotteTheme.colors.gray200,
        )
    }
}

@Composable
private fun BrandMenuItem(
    iconRes: Int,
    label: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(iconRes),
            contentDescription = null,
            tint = LotteTheme.colors.black,
            modifier = Modifier.size(24.dp),
        )
        Text(
            text = label,
            color = LotteTheme.colors.gray700,
            style = LotteTheme.typography.label.r12,
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    widthDp = 360,
)
@Composable
private fun BrandInfoContainerPreview() {
    LOTTESHOPPINGTheme {
        BrandInfoContainer(
            floor = "B1 화장품",
            brandName = "설화수",
            description = "전통의 지혜에서 영감을 받아 현대의 고유한 솔루션을 만드는 아모레퍼시픽의 한방 화장품 브랜드",
        )
    }
}
