package org.sopt.lotteshopping.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.colors
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.typography

enum class HomeServiceType(
    @get:DrawableRes val iconRes: Int,
    val label: String,
) {
    RESERVATION(R.drawable.ic_home_reservation, "예약"),
    BRANCH_INFO(R.drawable.ic_home_coupon, "쿠폰"),
    CULTURE_CENTER(R.drawable.ic_home_floor, "층별안내"),
    WEDDING(R.drawable.ic_home_car, "주차"),
    GIFT_CARD(R.drawable.ic_home_receipt, "영수증"),
    COUPON(R.drawable.ic_home_gift, "사은"),
    AI_CHATBOT(R.drawable.ic_home_ai, "AI 챗봇"),
}

@Composable
fun HomeServiceSection(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(colors.white),
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(HomeServiceType.entries) { service ->
                HomeServiceItem(
                    serviceType = service,
                )
            }
        }
    }
}

@Composable
fun HomeServiceItem(
    serviceType: HomeServiceType,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .width(58.dp)
            .background(color = colors.gray50, shape = RoundedCornerShape(size = 12.dp))
            .padding(top = 12.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = serviceType.iconRes),
            contentDescription = serviceType.label,
            tint = colors.black,
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = serviceType.label,
            style = typography.label.m12,
            color = colors.black,
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeServiceSectionPreview() {
    LOTTESHOPPINGTheme {
        HomeServiceSection()
    }
}
