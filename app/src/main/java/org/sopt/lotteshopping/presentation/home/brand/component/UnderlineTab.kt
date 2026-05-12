package org.sopt.lotteshopping.presentation.home.brand.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
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
            .width(IntrinsicSize.Max)
            .semantics(mergeDescendants = true) {
                role = Role.Tab
                this.selected = selected
            }
            .noRippleClickable(onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(bottom = if (selected) 10.dp else 12.dp),
            color = if (selected) LotteTheme.colors.black else LotteTheme.colors.gray300,
            style = LotteTheme.typography.body.m14,
            maxLines = 1,
            textAlign = TextAlign.Center,
        )

        if (selected) {
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(),
                thickness = 2.dp,
                color = LotteTheme.colors.black,
            )
        }
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
