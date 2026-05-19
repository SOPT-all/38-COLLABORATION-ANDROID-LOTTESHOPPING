package org.sopt.lotteshopping.data.remote.datasourceImpl

import org.sopt.lotteshopping.data.remote.datasource.ShoppingDataSource
import org.sopt.lotteshopping.data.remote.dto.BaseResponse
import org.sopt.lotteshopping.data.remote.dto.shopping.NewsResponseDto
import org.sopt.lotteshopping.data.remote.dto.shopping.ShoppingHighlightResponseDto
import org.sopt.lotteshopping.data.remote.service.ShoppingService
import javax.inject.Inject

class ShoppingDataSourceImpl @Inject constructor(
    private val shoppingService: ShoppingService,
): ShoppingDataSource {
    override suspend fun getShoppingHighlight(limit: Int): BaseResponse<List<ShoppingHighlightResponseDto>> =
        shoppingService.getShoppingHighlight(limit)


    override suspend fun getNews(category: String): BaseResponse<List<NewsResponseDto>> =
        shoppingService.getNews(category)
}
