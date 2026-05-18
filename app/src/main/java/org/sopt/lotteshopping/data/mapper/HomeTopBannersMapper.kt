package org.sopt.lotteshopping.data.mapper

import org.sopt.lotteshopping.data.model.banners.HomeTopBannerModel
import org.sopt.lotteshopping.data.remote.dto.banners.GetHomeTopBannersResponse

fun GetHomeTopBannersResponse.toModel() = HomeTopBannerModel(
    id = id.toLong(),
    seq = seq.toLong(),
    imageUrl = imageUrl ?: ""
)
