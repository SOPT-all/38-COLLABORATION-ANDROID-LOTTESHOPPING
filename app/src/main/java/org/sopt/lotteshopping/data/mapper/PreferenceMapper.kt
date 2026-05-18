package org.sopt.lotteshopping.data.mapper

import org.sopt.lotteshopping.data.model.preferences.HomePreferenceModel
import org.sopt.lotteshopping.data.remote.dto.preferences.PreferenceResponseDto

fun PreferenceResponseDto.toModel(): HomePreferenceModel =
    HomePreferenceModel(
        id = id,
        title = title,
        targetBranch = targetBranch,
        startDate = startDate,
        endDate = endDate,
        imageUrl = imageUrl,
    )
