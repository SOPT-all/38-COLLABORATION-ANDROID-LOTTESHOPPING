package org.sopt.lotteshopping.presentation.home

import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.data.model.banners.HomeTopBannerModel
import org.sopt.lotteshopping.data.model.brands.BeautyBrandModel
import org.sopt.lotteshopping.presentation.home.component.HomeStoreTab
import org.sopt.lotteshopping.presentation.home.component.HomeTabType
import org.sopt.lotteshopping.presentation.home.model.BeautyContentModel

data class HomeUiState(
    val selectedHomeTab: HomeTabType = HomeTabType.DEPARTMENT_STORE,
    val selectedStoreTab: HomeStoreTab = HomeStoreTab.DEPARTMENT_STORE,
    val banners: List<HomeTopBannerModel> = emptyList(),
    val brands: List<BeautyBrandModel> = emptyList(),
    val contents: List<BeautyContentModel> = listOf(
        BeautyContentModel(R.drawable.img_home_collection_aesop, "[Aesop]", "감각적인 데일리 케어"),
        BeautyContentModel(R.drawable.img_home_collection_sulwhasoo, "[Sulwhasoo]", "윤빛 케어 에센셜"),
        BeautyContentModel(R.drawable.img_home_collection_kiehls, "[Kiehl's]", "가정의달 프로모션"),
        BeautyContentModel(R.drawable.img_home_collection_sk2, "[SK-II]", "FESTA 특별 이벤트")
    ),
)
