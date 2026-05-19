package org.sopt.lotteshopping.data.remote.dto.banners

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetHomeBottomBannerResponse(
    @SerialName("id")
    val id: Long,
    @SerialName("imageUrl")
    val imageUrl: String,
)