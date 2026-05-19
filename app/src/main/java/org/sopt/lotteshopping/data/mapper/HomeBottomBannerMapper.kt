package org.sopt.lotteshopping.data.mapper

import org.sopt.lotteshopping.data.model.banners.HomeBottomBannerModel
import org.sopt.lotteshopping.data.remote.dto.banners.GetHomeBottomBannerResponse

fun GetHomeBottomBannerResponse.toModel() = HomeBottomBannerModel(
    id = id,
    imageUrl = imageUrl,
)