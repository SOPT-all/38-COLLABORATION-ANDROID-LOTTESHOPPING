package org.sopt.lotteshopping.data.remote.dto.shopping

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShoppingHighlightResponseDto(
    @SerialName("id")
    val id: Long,
    @SerialName("imageUrl")
    val imageUrl: String,
)
