package org.sopt.lotteshopping.data.remote.dto.shopping

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponseDto (
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("startDate")
    val startDate: String,
    @SerialName("endDate")
    val endDate: String,
    @SerialName("targetBranch")
    val targetBranch: String,
    @SerialName("imageUrl")
    val imageUrl: String,
)
