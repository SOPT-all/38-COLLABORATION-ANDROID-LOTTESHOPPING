package org.sopt.lotteshopping.data.repository

import org.sopt.lotteshopping.data.model.preferences.HomePreferenceModel

// #[FEAT/#31]
interface PreferenceRepository {
    suspend fun getPreferences(): Result<List<HomePreferenceModel>>
}
