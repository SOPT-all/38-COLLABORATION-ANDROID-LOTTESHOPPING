package org.sopt.lotteshopping.presentation.shopping

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import org.sopt.lotteshopping.data.model.shopping.ShoppingHighlightModel
import org.sopt.lotteshopping.data.model.shopping.NewsCategory
import org.sopt.lotteshopping.data.model.shopping.NewsModel

@Immutable
data class ShoppingUiState(
    val highlights: ImmutableList<ShoppingHighlightModel> = persistentListOf(),
    val news: ImmutableList<NewsModel> = persistentListOf(),
    val selectedCategory: NewsCategory = NewsCategory.ALL,
    val categories: ImmutableList<NewsCategory> = NewsCategory.entries.toImmutableList(),
)
