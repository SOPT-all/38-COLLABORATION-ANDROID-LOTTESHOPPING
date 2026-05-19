package org.sopt.lotteshopping.data.remote.service

import org.sopt.lotteshopping.data.remote.dto.BaseResponse
import org.sopt.lotteshopping.data.remote.dto.banners.GetHomeBottomBannerResponse
import org.sopt.lotteshopping.data.remote.dto.banners.GetHomeTopBannersResponse
import retrofit2.http.GET

interface BannersService {
    @GET("api/v1/banners/top")
    suspend fun getHomeTopBanners():  BaseResponse<List<GetHomeTopBannersResponse>>

    @GET("api/v1/banners/bottom")
    suspend fun getHomeBottomBanner(): BaseResponse<GetHomeBottomBannerResponse>
}
