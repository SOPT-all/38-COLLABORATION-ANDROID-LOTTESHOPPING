package org.sopt.lotteshopping.data.remote.datasource

import org.sopt.lotteshopping.data.remote.dto.BaseResponse
import org.sopt.lotteshopping.data.remote.dto.shopping.NewsResponseDto
import org.sopt.lotteshopping.data.remote.dto.shopping.ShoppingHighlightResponseDto

interface ShoppingDataSource {
    suspend fun getShoppingHighlight(limit: Int): BaseResponse<List<ShoppingHighlightResponseDto>>

    suspend fun getNews(category: String): BaseResponse<List<NewsResponseDto>>
}
