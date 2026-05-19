package org.sopt.lotteshopping.data.remote.service

import org.sopt.lotteshopping.data.remote.dto.preferences.GetPreferencesResponse
import retrofit2.http.GET

// #[FEAT/#31]
interface PreferenceService {
    @GET("api/v1/preferences")
    suspend fun getPreferences(): GetPreferencesResponse
}
