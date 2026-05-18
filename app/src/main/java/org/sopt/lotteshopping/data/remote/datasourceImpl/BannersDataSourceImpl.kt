package org.sopt.lotteshopping.data.remote.datasourceImpl

import org.sopt.lotteshopping.data.remote.datasource.BannersDataSource
import org.sopt.lotteshopping.data.remote.dto.BaseResponse
import org.sopt.lotteshopping.data.remote.dto.banners.GetHomeTopBannersResponse
import org.sopt.lotteshopping.data.remote.service.BannersService
import javax.inject.Inject

class BannersDataSourceImpl @Inject constructor(
    private val bannersService: BannersService
) : BannersDataSource {
    override suspend fun getHomeTopBanners(): BaseResponse<List<GetHomeTopBannersResponse>> =
        bannersService.getHomeTopBanners()
}
