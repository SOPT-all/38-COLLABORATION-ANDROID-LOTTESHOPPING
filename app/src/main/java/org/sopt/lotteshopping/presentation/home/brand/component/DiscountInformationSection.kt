package org.sopt.lotteshopping.presentation.home.brand.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme

@Composable
fun DiscountInformationSection(
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
