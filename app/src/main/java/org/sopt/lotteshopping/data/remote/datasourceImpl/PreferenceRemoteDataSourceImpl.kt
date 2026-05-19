package org.sopt.lotteshopping.data.remote.datasourceImpl

import org.sopt.lotteshopping.data.remote.datasource.PreferenceRemoteDataSource
import org.sopt.lotteshopping.data.remote.dto.BaseResponse
import org.sopt.lotteshopping.data.remote.dto.preferences.PreferenceResponseDto
import org.sopt.lotteshopping.data.remote.service.PreferenceService
import javax.inject.Inject

// #[FEAT/#31]
class PreferenceRemoteDataSourceImpl @Inject constructor(
    private val preferenceService: PreferenceService,
) : PreferenceRemoteDataSource {
    override suspend fun getPreferences(): BaseResponse<List<PreferenceResponseDto>> =
        preferenceService.getPreferences()
}
