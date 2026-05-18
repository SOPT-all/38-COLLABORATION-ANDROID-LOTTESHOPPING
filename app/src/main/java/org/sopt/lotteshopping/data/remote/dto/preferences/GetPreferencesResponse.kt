package org.sopt.lotteshopping.data.remote.dto.preferences

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetPreferencesResponse(
    @SerialName("status")
    val status: Int,
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<PreferenceResponseDto>?,
)

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
