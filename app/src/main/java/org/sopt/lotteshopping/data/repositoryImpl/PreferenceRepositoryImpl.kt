package org.sopt.lotteshopping.data.repositoryImpl

import org.sopt.lotteshopping.data.mapper.toModel
import org.sopt.lotteshopping.data.model.preferences.HomePreferenceModel
import org.sopt.lotteshopping.data.remote.datasource.PreferenceRemoteDataSource
import org.sopt.lotteshopping.data.repository.PreferenceRepository
import javax.inject.Inject

// #[FEAT/#31]
class PreferenceRepositoryImpl @Inject constructor(
    private val preferenceRemoteDataSource: PreferenceRemoteDataSource,
) : PreferenceRepository {
    override suspend fun getPreferences(): Result<List<HomePreferenceModel>> =
        runCatching {
            preferenceRemoteDataSource.getPreferences().data?.map { it.toModel() }.orEmpty()
        }
}
