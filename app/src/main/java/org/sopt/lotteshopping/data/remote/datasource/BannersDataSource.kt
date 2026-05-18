package org.sopt.lotteshopping.data.remote.datasource

import org.sopt.lotteshopping.data.remote.dto.BaseResponse
import org.sopt.lotteshopping.data.remote.dto.banners.GetHomeTopBannersResponse

interface BannersRemoteDataSource {
    suspend fun getHomeTopBanners(): BaseResponse<List<GetHomeTopBannersResponse>>
}
