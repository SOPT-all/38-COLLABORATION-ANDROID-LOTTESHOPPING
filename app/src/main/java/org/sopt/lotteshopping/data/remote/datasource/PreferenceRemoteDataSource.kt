package org.sopt.lotteshopping.data.remote.datasource

import org.sopt.lotteshopping.data.remote.dto.BaseResponse
import org.sopt.lotteshopping.data.remote.dto.preferences.PreferenceResponseDto

interface PreferenceRemoteDataSource {
    suspend fun getPreferences(): BaseResponse<List<PreferenceResponseDto>>
}
