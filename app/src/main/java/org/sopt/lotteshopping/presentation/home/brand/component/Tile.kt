package org.sopt.lotteshopping.presentation.home.brand.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme

@Composable
fun Tile(
    label: String,
    modifier: Modifier = Modifier,
    showCheckBadge: Boolean = true,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(
                    color = LotteTheme.colors.gray50,
                    shape = RoundedCornerShape(8.dp),
                ),
        ) {
            if (showCheckBadge) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_brand_checkbadge),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(
                            top = 4.dp,
                            end = 4.dp,
                        )
                        .size(12.dp),
                )
            }
        }

        Text(
            text = label,
            color = LotteTheme.colors.gray700,
            style = LotteTheme.typography.label.m12,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TilePreview() {
    LOTTESHOPPINGTheme {
        Box(
            modifier = Modifier
                .background(LotteTheme.colors.white)
                .padding(24.dp),
        ) {
            Tile(label = "지류 상품권")
        }
    }
}
