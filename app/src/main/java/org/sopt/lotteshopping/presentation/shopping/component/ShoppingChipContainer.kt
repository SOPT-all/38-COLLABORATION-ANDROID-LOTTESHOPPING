package org.sopt.lotteshopping.presentation.shopping.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.core.extension.noRippleClickable
import org.sopt.lotteshopping.data.model.info.NewsCategory

@Composable
fun ShoppingChipContainer(
    categories: ImmutableList<NewsCategory>,
    selectedCategory: NewsCategory,
    onCategoryClick: (NewsCategory) -> Unit,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        maxItemsInEachRow = 4,
    ) {
        categories.forEach { category ->
            Chip(
                label = category.displayName,
                type = if (category == selectedCategory) ChipType.ACTIVE else ChipType.DEFAULT,
                onClick = { onCategoryClick(category) },
            )
        }
    }
}

private enum class ChipType {
    ACTIVE, DEFAULT;

    val textColor: Color
        @Composable get() = when (this) {
            ACTIVE -> LotteTheme.colors.white
            DEFAULT -> LotteTheme.colors.black
        }

    val backgroundColor: Color
        @Composable get() = when (this) {
            ACTIVE -> LotteTheme.colors.black
            DEFAULT -> LotteTheme.colors.white
        }

    val borderColor: Color
        @Composable get() = when (this) {
            ACTIVE -> LotteTheme.colors.black
            DEFAULT -> LotteTheme.colors.gray200
        }
}

@Composable
private fun Chip(
    label: String,
    type: ChipType,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Text(
        text = label,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .noRippleClickable(onClick)
            .background(type.backgroundColor)
            .border(
                width = 1.dp,
                color = type.borderColor,
                shape = RoundedCornerShape(8.dp),
            )
            .padding(horizontal = 14.dp)
            .padding(top = 6.dp, bottom = 8.dp),
        color = type.textColor,
        style = LotteTheme.typography.label.m12,
    )
}

@Preview(showBackground = true)
@Composable
private fun ShoppingChipContainerPreview() {
    LOTTESHOPPINGTheme {
        ShoppingChipContainer(
            categories = NewsCategory.entries.toImmutableList(),
            selectedCategory = NewsCategory.ALL,
            onCategoryClick = {},
            modifier = Modifier.padding(all = 20.dp)
        )
    }
}
