package org.sopt.lotteshopping.data.remote.dto.banners

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetHomeTopBannersResponse(
    @SerialName("id")
    val id: Long,
    @SerialName("seq")
    val seq: Long,
    @SerialName("imageUrl")
    val imageUrl: String?,
)
