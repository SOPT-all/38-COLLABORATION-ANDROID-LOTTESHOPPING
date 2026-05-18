package org.sopt.lotteshopping.data.remote.service

import org.sopt.lotteshopping.data.remote.dto.BaseResponse
import org.sopt.lotteshopping.data.remote.dto.shopping.NewsResponseDto
import org.sopt.lotteshopping.data.remote.dto.shopping.ShoppingHighlightResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ShoppingService {
    @GET("/api/v1/shopping-highlight/highlight")
    suspend fun getShoppingHighlight(
        @Query("limit") limit: Int,
    ): BaseResponse<List<ShoppingHighlightResponseDto>>

    @GET("/api/v1/shopping/news")
    suspend fun getNews(
        @Query("category") category: String,
    ): BaseResponse<List<NewsResponseDto>>
}
