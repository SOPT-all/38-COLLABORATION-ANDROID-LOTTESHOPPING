package org.sopt.lotteshopping.presentation.home.brand.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.core.extension.noRippleClickable

@Composable
fun BrandHeader(
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.background(LotteTheme.colors.white),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 12.dp,
                    vertical = 10.dp,
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BrandHeaderIconButton(
                iconRes = R.drawable.ic_header_arrow,
                onClick = onBackClick,
            )

            Row {
                BrandHeaderIconButton(
                    iconRes = R.drawable.ic_header_home,
                    onClick = onHomeClick,
                )
                BrandHeaderIconButton(
                    iconRes = R.drawable.ic_header_share,
                    onClick = onShareClick,
                )
            }
        }
        HorizontalDivider(
            thickness = 0.5.dp,
            color = LotteTheme.colors.gray100,
        )
    }
}

@Composable
private fun BrandHeaderIconButton(
    iconRes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .noRippleClickable(onClick)
            .size(36.dp),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(iconRes),
            contentDescription = null,
            tint = LotteTheme.colors.black,
            modifier = Modifier.size(24.dp),
        )
    }
}
