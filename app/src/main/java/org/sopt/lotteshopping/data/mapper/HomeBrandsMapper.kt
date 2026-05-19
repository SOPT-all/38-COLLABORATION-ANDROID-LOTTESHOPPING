package org.sopt.lotteshopping.data.mapper

import org.sopt.lotteshopping.data.model.brands.HomeBeautyBrandModel
import org.sopt.lotteshopping.data.remote.dto.brands.GetHomeBrandsResponse

fun GetHomeBrandsResponse.toModel() = HomeBeautyBrandModel(
    id = id,
    name = name,
    imageUrl = imageUrl,
)
