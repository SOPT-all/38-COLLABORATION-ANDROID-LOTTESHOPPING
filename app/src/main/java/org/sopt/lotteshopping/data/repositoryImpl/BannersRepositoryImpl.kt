package org.sopt.lotteshopping.data.repositoryImpl

import org.sopt.lotteshopping.core.util.suspendRunCatching
import org.sopt.lotteshopping.data.mapper.toModel
import org.sopt.lotteshopping.data.model.banners.HomeBottomBannerModel
import org.sopt.lotteshopping.data.model.banners.HomeTopBannerModel
import org.sopt.lotteshopping.data.remote.datasource.BannersRemoteDataSource
import org.sopt.lotteshopping.data.repository.BannersRepository
import javax.inject.Inject

class BannersRepositoryImpl @Inject constructor(
    private val bannersDataSource: BannersRemoteDataSource
) : BannersRepository {

    override suspend fun getHomeTopBanners(): Result<List<HomeTopBannerModel>> = suspendRunCatching {
        bannersDataSource.getHomeTopBanners().data?.map { it.toModel() } ?: emptyList()
    }

    override suspend fun getHomeBottomBanner(): Result<HomeBottomBannerModel> = suspendRunCatching {
        requireNotNull(bannersDataSource.getHomeBottomBanner().data).toModel()
    }
}