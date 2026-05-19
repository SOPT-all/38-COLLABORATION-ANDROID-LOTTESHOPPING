package org.sopt.lotteshopping.data.remote.datasource

import org.sopt.lotteshopping.data.remote.dto.BaseResponse
import org.sopt.lotteshopping.data.remote.dto.preferences.PreferenceResponseDto

// #[FEAT/#31]
interface PreferenceRemoteDataSource {
    suspend fun getPreferences(): BaseResponse<List<PreferenceResponseDto>>
}
