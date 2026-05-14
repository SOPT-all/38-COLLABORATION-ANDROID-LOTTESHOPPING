package org.sopt.lotteshopping.presentation.shopping

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import org.sopt.lotteshopping.core.common.state.UiState
import org.sopt.lotteshopping.data.model.info.HighlightModel
import org.sopt.lotteshopping.data.model.info.NewsCategory
import org.sopt.lotteshopping.data.model.info.NewsModel

@Immutable
data class ShoppingUiState(
    val highlights: ImmutableList<HighlightModel> = persistentListOf(),
    val news: ImmutableList<NewsModel> = persistentListOf(),
    val selectedCategory: NewsCategory = NewsCategory.ALL,
    val categories: ImmutableList<NewsCategory> = NewsCategory.entries.toImmutableList(),
)
