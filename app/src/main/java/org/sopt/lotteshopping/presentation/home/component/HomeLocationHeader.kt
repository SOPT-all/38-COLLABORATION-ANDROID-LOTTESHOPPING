package org.sopt.lotteshopping.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.colors
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.typography


@Composable
fun HomeLocationHeader(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(colors.black)
            .padding(horizontal = 16.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "백화점",
            color = colors.white,
            style = typography.title.m18,
        )
        Text(
            text = " 노원점",
            color = colors.white,
            style = typography.title.sb18,
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_chevron_down),
            contentDescription = null,
            tint = colors.white,
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "휴점일",
            color = colors.gray300,
            style = typography.body.m14,
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "4.13 (월)",
            color = colors.white,
            style = typography.body.sb14,
        )
    }
}


@Preview
@Composable
private fun HomeLocationHeaderPreview(
) {
    LOTTESHOPPINGTheme {
        HomeLocationHeader()
    }
}
