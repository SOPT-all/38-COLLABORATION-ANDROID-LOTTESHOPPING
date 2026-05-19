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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.persistentListOf
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.data.model.shopping.ShoppingHighlightModel
import org.sopt.lotteshopping.data.model.shopping.NewsCategory
import org.sopt.lotteshopping.data.model.shopping.NewsModel
import org.sopt.lotteshopping.presentation.shopping.component.ShoppingCardProduct
import org.sopt.lotteshopping.presentation.shopping.component.ShoppingChipContainer
import org.sopt.lotteshopping.presentation.shopping.component.ShoppingHeader
import org.sopt.lotteshopping.presentation.shopping.component.ShoppingHighlightSection
import org.sopt.lotteshopping.presentation.shopping.component.ShoppingUnderlineTabContainer

@Composable
fun ShoppingRoute(
    modifier: Modifier = Modifier,
    viewModel: ShoppingViewModel = hiltViewModel(),
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

@Preview
@Composable
private fun ShoppingScreenPreview() {
    val highlights = persistentListOf(
        ShoppingHighlightModel(0L, ""),
        ShoppingHighlightModel(1L, ""),
        ShoppingHighlightModel(2L, ""),
        )
    
    val news = persistentListOf(
        NewsModel(
            id = 0L,
            title = "[뷰티살롱] 나만을 위한 뷰티 컨설팅",
            targetBranch = "백화점 전점",
            startDate = "4.1(수)",
            endDate = "4.30(목)",
            imageUrl = ""
        ),
        NewsModel(
            id = 1L,
            title = "[뷰티살롱] 나만을 위한 뷰티 컨설팅",
            targetBranch = "",
            startDate = "4.1(수)",
            endDate = "4.30(목)",
            imageUrl = ""
        ),
        NewsModel(
            id = 2L,
            title = "[뷰티살롱] 나만을 위한 뷰티 컨설팅",
            targetBranch = "백화점 전점",
            startDate = "4.1(수)",
            endDate = "4.30(목)",
            imageUrl = ""
        ),
    )

    LOTTESHOPPINGTheme { 
        ShoppingScreen(
            uiState = ShoppingUiState(
                highlights = highlights,
                news = news,
            ),
            onCategoryClick = {},
            modifier = Modifier.background(LotteTheme.colors.white)
        )
    }
}
