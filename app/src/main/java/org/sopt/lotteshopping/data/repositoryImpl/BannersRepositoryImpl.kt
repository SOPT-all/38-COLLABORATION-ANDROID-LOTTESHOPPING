package org.sopt.lotteshopping.data.repositoryImpl

import org.sopt.lotteshopping.data.mapper.toModel
import org.sopt.lotteshopping.data.model.banners.HomeTopBannerModel
import org.sopt.lotteshopping.data.remote.datasource.BannersRemoteDataSource
import org.sopt.lotteshopping.data.repository.BannersRepository
import javax.inject.Inject

class BannersRepositoryImpl @Inject constructor(
    private val bannersDataSource: BannersRemoteDataSource
) : BannersRepository {
    override suspend fun getHomeTopBanners(): Result<List<HomeTopBannerModel>> = runCatching {
        bannersDataSource.getHomeTopBanners().data?.map { it.toModel() } ?: emptyList()
    }
}
