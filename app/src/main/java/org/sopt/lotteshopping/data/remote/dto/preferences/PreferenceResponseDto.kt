package org.sopt.lotteshopping.data.remote.dto.preferences

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// #[FEAT/#31]
@Serializable
data class PreferenceResponseDto(
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("targetBranch")
    val targetBranch: String,
    @SerialName("startDate")
    val startDate: String,
    @SerialName("endDate")
    val endDate: String,
    @SerialName("imageUrl")
    val imageUrl: String,
)
