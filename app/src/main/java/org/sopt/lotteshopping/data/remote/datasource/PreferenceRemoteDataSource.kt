package org.sopt.lotteshopping.data.remote.datasource

import org.sopt.lotteshopping.data.remote.dto.preferences.GetPreferencesResponse

// #[FEAT/#31]
interface PreferenceRemoteDataSource {
    suspend fun getPreferences(): GetPreferencesResponse
}
