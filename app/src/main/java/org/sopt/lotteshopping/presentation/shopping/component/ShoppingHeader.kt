package org.sopt.lotteshopping.presentation.shopping.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun ShoppingHeader(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 30.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "백화점 노원점",
                color = LotteTheme.colors.black,
                style = LotteTheme.typography.title.sb18,
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_chevron_down),
                contentDescription = null,
                tint = LotteTheme.colors.black,
            )
        }

        Text(
            text = "쇼핑소식을 만나보세요",
            color = LotteTheme.colors.black,
            style = LotteTheme.typography.label.r12,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShoppingHeaderPreview() {
    LOTTESHOPPINGTheme {
        ShoppingHeader()
    }
}
