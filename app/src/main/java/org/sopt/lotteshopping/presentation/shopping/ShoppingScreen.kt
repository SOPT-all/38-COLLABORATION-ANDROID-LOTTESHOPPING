package org.sopt.lotteshopping.presentation.shopping

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.data.model.info.NewsCategory
import org.sopt.lotteshopping.presentation.shopping.component.ShoppingCardProduct
import org.sopt.lotteshopping.presentation.shopping.component.ShoppingChipContainer
import org.sopt.lotteshopping.presentation.shopping.component.ShoppingHeader
import org.sopt.lotteshopping.presentation.shopping.component.ShoppingHighlightSection
import org.sopt.lotteshopping.presentation.shopping.component.ShoppingUnderlineTabContainer

@Composable
fun ShoppingRoute(
    modifier: Modifier = Modifier,
    viewModel: ShoppingViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ShoppingScreen(
        uiState = uiState,
        onCategoryClick = viewModel::onCategoryClick,
        modifier = modifier,
    )
}

@Composable
private fun ShoppingScreen(
    uiState: ShoppingUiState,
    onCategoryClick: (NewsCategory) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(bottom = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        stickyHeader {
            ShoppingHeader(
                modifier = Modifier.background(LotteTheme.colors.white)
            )
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            ShoppingHighlightSection(
                highlights = uiState.highlights,
            )
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            ShoppingUnderlineTabContainer()
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            ShoppingChipContainer(
                categories = uiState.categories,
                selectedCategory = uiState.selectedCategory,
                onCategoryClick = onCategoryClick,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 14.dp, bottom = 26.dp)
            )
        }

        itemsIndexed(items = uiState.news, key = { _, news -> news.id }) { index, news ->
            ShoppingCardProduct(
                news = news,
                modifier = Modifier
                    .padding(
                        bottom = 20.dp,
                        start = if (index % 2 == 0) 20.dp else 0.dp,
                        end = if (index % 2 != 0) 20.dp else 0.dp,
                    )
            )
        }
    }
}
