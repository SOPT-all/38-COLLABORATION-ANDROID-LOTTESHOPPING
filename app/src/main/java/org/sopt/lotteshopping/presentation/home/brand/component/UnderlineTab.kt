package org.sopt.lotteshopping.presentation.home.brand.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.core.extension.noRippleClickable

@Composable
fun UnderlineTab(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .semantics(mergeDescendants = true) {
                role = Role.Tab
                this.selected = selected
            }
            .noRippleClickable(onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Text(
            text = label,
            color = if (selected) LotteTheme.colors.black else LotteTheme.colors.gray300,
            style = LotteTheme.typography.body.m14,
            textAlign = TextAlign.Center,
        )

        Box(
            modifier = Modifier
                .width(if (selected) 74.dp else 28.dp)
                .height(2.dp)
                .background(
                    if (selected) {
                        LotteTheme.colors.black
                    } else {
                        LotteTheme.colors.white
                    },
                ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun UnderlineTabPreview() {
    LOTTESHOPPINGTheme {
        Row(
            modifier = Modifier.padding(24.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.Top,
        ) {
            UnderlineTab(
                label = "브랜드 뉴스",
                selected = true,
                onClick = {},
            )
            UnderlineTab(
                label = "리뷰",
                selected = false,
                onClick = {},
            )
        }
    }
}
