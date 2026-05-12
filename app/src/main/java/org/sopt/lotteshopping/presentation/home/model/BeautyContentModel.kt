package org.sopt.lotteshopping.presentation.home.model

import androidx.annotation.DrawableRes

data class BeautyContentModel(
    @get:DrawableRes val imageRes: Int,
    val brandName: String,
    val description: String,
)
