package org.sopt.lotteshopping.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.colors
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.typography
import org.sopt.lotteshopping.R

@Composable
fun HomeServiceItem(
    iconRes: Int,
    label: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(color = colors.gray50, shape = RoundedCornerShape(size = 12.dp))
            .padding(vertical = 12.dp, horizontal = 13.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = iconRes),
            contentDescription = null,
            tint = colors.black,
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = label,
            style = typography.label.m12,
            color = colors.black,
        )
    }
}

@Preview
@Composable
private fun HomeServiceItemPreview(
) {
    LOTTESHOPPINGTheme {
        Column(
            modifier = Modifier
                .background(colors.white)
                .padding(16.dp),
        ){
            HomeServiceItem(
                iconRes = R.drawable.ic_home_reservation,
                label = "예약"
            )
        }
    }
}
