package org.sopt.lotteshopping.data.remote.dto.banners

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetHomeTopBannersResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("seq")
    val seq: Int,
    @SerialName("imageUrl")
    val imageUrl: String?,
)
