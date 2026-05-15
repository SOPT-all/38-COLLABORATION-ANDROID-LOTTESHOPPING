package org.sopt.lotteshopping.presentation.home.model

import androidx.annotation.DrawableRes
import org.sopt.lotteshopping.R

data class HomeOnlineItemModel(
    @get:DrawableRes val imageRes: Int,
    val label: String,
    val title: String,
)
