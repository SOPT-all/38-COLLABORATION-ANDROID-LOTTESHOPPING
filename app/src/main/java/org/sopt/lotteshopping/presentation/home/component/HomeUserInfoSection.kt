package org.sopt.lotteshopping.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.colors
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.typography


@Composable
fun HomeUserInfoSection(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(colors.black)
            .padding(horizontal = 12.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "안녕하세요",
            color = colors.gray300,
            style = typography.body.m14,
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = "김*트님!",
            color = colors.white,
            style = typography.body.sb14,
        )

        Spacer(modifier = Modifier.weight(1f))

        HomeUserInfoButton()

    }
}

@Composable
private fun HomeUserInfoButton(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .border(
                width = 0.5.dp,
                color = colors.gray600,
                shape = CircleShape,
            )
            .padding(vertical = 4.dp)
            .padding(start = 14.dp, end = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "등급·선정내역",
            style = typography.label.m12,
            color = colors.white,
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_chevron_right),
            contentDescription = null,
            tint = colors.white,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeUserInfoSectionPreview() {
    HomeUserInfoSection()
}
