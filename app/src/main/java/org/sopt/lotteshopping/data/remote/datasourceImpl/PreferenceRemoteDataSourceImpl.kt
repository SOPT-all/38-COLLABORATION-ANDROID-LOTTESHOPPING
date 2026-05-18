package org.sopt.lotteshopping.data.remote.datasourceImpl

import org.sopt.lotteshopping.data.remote.datasource.PreferenceRemoteDataSource
import org.sopt.lotteshopping.data.remote.dto.preferences.GetPreferencesResponse
import org.sopt.lotteshopping.data.remote.service.PreferenceService
import javax.inject.Inject

class PreferenceRemoteDataSourceImpl @Inject constructor(
    private val preferenceService: PreferenceService,
) : PreferenceRemoteDataSource {
    override suspend fun getPreferences(): GetPreferencesResponse =
        preferenceService.getPreferences()
}
