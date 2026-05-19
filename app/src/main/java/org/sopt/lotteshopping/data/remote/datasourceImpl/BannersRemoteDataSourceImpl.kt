package org.sopt.lotteshopping.data.remote.datasourceImpl

import org.sopt.lotteshopping.data.remote.datasource.BannersRemoteDataSource
import org.sopt.lotteshopping.data.remote.dto.BaseResponse
import org.sopt.lotteshopping.data.remote.dto.banners.GetHomeBottomBannerResponse
import org.sopt.lotteshopping.data.remote.dto.banners.GetHomeTopBannersResponse
import org.sopt.lotteshopping.data.remote.service.BannersService
import javax.inject.Inject

class BannersRemoteDataSourceImpl @Inject constructor(
    private val bannersService: BannersService
) : BannersRemoteDataSource {
    override suspend fun getHomeTopBanners(): BaseResponse<List<GetHomeTopBannersResponse>> =
        bannersService.getHomeTopBanners()

    override suspend fun getHomeBottomBanner(): BaseResponse<GetHomeBottomBannerResponse> =
        bannersService.getHomeBottomBanner()
}
