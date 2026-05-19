package org.sopt.lotteshopping.data.repository

import org.sopt.lotteshopping.data.model.preferences.HomePreferenceModel

interface PreferenceRepository {
    suspend fun getPreferences(): Result<List<HomePreferenceModel>>
}
