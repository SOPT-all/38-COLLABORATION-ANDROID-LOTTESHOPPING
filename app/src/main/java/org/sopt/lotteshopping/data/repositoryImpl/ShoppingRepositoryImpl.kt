package org.sopt.lotteshopping.data.repositoryImpl

import org.sopt.lotteshopping.core.util.suspendRunCatching
import org.sopt.lotteshopping.data.mapper.toModel
import org.sopt.lotteshopping.data.model.shopping.NewsCategory
import org.sopt.lotteshopping.data.model.shopping.NewsModel
import org.sopt.lotteshopping.data.model.shopping.ShoppingHighlightModel
import org.sopt.lotteshopping.data.remote.datasource.ShoppingDataSource
import org.sopt.lotteshopping.data.repository.ShoppingRepository
import javax.inject.Inject

class ShoppingRepositoryImpl @Inject constructor(
    private val shoppingDataSource: ShoppingDataSource,
) : ShoppingRepository {
    override suspend fun getShoppingHighlight(): Result<List<ShoppingHighlightModel>> =
        suspendRunCatching {
            shoppingDataSource.getShoppingHighlight(5)
                .data?.toModel() ?: emptyList()
        }

    override suspend fun getNews(category: NewsCategory): Result<List<NewsModel>> =
        suspendRunCatching {
            shoppingDataSource.getNews(category.api)
                .data?.toModel() ?: emptyList()
        }
}
