package org.sopt.lotteshopping.data.model.brands

import androidx.annotation.DrawableRes

data class BeautyContentModel(
    @get:DrawableRes val imageRes: Int,
    val brandName: String,
    val description: String
)
