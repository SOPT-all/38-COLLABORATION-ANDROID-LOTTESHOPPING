package org.sopt.lotteshopping.data.mapper

import org.sopt.lotteshopping.data.model.shopping.NewsModel
import org.sopt.lotteshopping.data.model.shopping.ShoppingHighlightModel
import org.sopt.lotteshopping.data.remote.dto.shopping.NewsResponseDto
import org.sopt.lotteshopping.data.remote.dto.shopping.ShoppingHighlightResponseDto

fun ShoppingHighlightResponseDto.toModel(): ShoppingHighlightModel =
    ShoppingHighlightModel(
        id = this.id,
        imageUrl = this.imageUrl,
    )

@JvmName("shoppingHighlightListToModel")
fun List<ShoppingHighlightResponseDto>.toModel(): List<ShoppingHighlightModel> =
    this.map { it.toModel() }

fun NewsResponseDto.toModel(): NewsModel  =
    NewsModel(
        id = this.id,
        title = this.title,
        targetBranch = this.targetBranch,
        startDate = this.startDate,
        endDate = this.endDate,
        imageUrl = this.imageUrl,
    )

@JvmName("newsListToModel")
fun List<NewsResponseDto>.toModel() : List<NewsModel> =
    this.map { it.toModel() }
