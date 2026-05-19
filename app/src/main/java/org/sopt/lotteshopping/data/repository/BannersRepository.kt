package org.sopt.lotteshopping.data.repository

import org.sopt.lotteshopping.data.model.banners.HomeBottomBannerModel
import org.sopt.lotteshopping.data.model.banners.HomeTopBannerModel

interface BannersRepository {
    suspend fun getHomeTopBanners(): Result<List<HomeTopBannerModel>>
    suspend fun getHomeBottomBanner(): Result<HomeBottomBannerModel?>
}
