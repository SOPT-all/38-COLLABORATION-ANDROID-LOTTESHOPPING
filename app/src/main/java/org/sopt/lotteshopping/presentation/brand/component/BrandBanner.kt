package org.sopt.lotteshopping.presentation.brand.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme

@Composable
fun BrandBanner(
    brandName: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(LotteTheme.colors.lime500)
            .padding(
                horizontal = 18.dp,
                vertical = 14.dp,
            ),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BrandLogo()

        Column {
            Row {
                Text(
                    text = "‘$brandName’",
                    color = LotteTheme.colors.black,
                    style = LotteTheme.typography.body.sb14,
                )
                Text(
                    text = "을",
                    color = LotteTheme.colors.black,
                    style = LotteTheme.typography.body.m14,
                )
            }
            Text(
                text = "롯데백화점몰에서 찾아봐요!",
                color = LotteTheme.colors.black,
                style = LotteTheme.typography.body.m14,
            )
        }
    }
}

@Composable
private fun BrandLogo(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(R.drawable.img_lotte_department_mall_logo),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(44.dp)
            .clip(RoundedCornerShape(10.dp)),
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    widthDp = 320,
    heightDp = 72,
)
@Composable
private fun BrandBannerPreview() {
    LOTTESHOPPINGTheme {
        BrandBanner(
            brandName = "비오템",
            modifier = Modifier.width(320.dp),
        )
    }
}
