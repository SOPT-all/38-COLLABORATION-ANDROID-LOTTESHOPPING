package org.sopt.lotteshopping.data.remote.dto.brands

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetHomeBrandsResponse(
    @SerialName("id")
    val id: Long?,
    @SerialName("name")
    val name: String?,
    @SerialName("imageUrl")
    val imageUrl: String?,
) {
}
