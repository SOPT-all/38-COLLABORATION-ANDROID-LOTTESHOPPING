package org.sopt.lotteshopping.data.repository

import org.sopt.lotteshopping.data.model.shopping.NewsCategory
import org.sopt.lotteshopping.data.model.shopping.NewsModel
import org.sopt.lotteshopping.data.model.shopping.ShoppingHighlightModel

interface ShoppingRepository {
    suspend fun getShoppingHighlight(): Result<List<ShoppingHighlightModel>>

    suspend fun getNews(category: NewsCategory): Result<List<NewsModel>>
}