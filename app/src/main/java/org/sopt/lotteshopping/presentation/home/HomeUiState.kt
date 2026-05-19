package org.sopt.lotteshopping.presentation.home

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.data.model.banners.HomeBottomBannerModel
import org.sopt.lotteshopping.data.model.banners.HomeTopBannerModel
import org.sopt.lotteshopping.data.model.brands.HomeBeautyBrandModel
import org.sopt.lotteshopping.data.model.preferences.HomePreferenceModel
import org.sopt.lotteshopping.presentation.home.component.HomeStoreTab
import org.sopt.lotteshopping.presentation.home.component.HomeTabType
import org.sopt.lotteshopping.presentation.home.model.BeautyContentModel
import org.sopt.lotteshopping.presentation.home.model.HomeOnlineItemModel

data class HomeUiState(
    val selectedHomeTab: HomeTabType = HomeTabType.DEPARTMENT_STORE,
    val selectedStoreTab: HomeStoreTab = HomeStoreTab.DEPARTMENT_STORE,
    val topBanners: ImmutableList<HomeTopBannerModel> = persistentListOf(),
    val brands: ImmutableList<HomeBeautyBrandModel> = persistentListOf(),
    val contents: ImmutableList<BeautyContentModel> = persistentListOf(
        BeautyContentModel(R.drawable.img_home_collection_aesop, "[Aesop]", "감각적인 데일리 케어"),
        BeautyContentModel(R.drawable.img_home_collection_sulwhasoo, "[Sulwhasoo]", "윤빛 케어 에센셜"),
        BeautyContentModel(R.drawable.img_home_collection_kiehls, "[Kiehl's]", "가정의달 프로모션"),
        BeautyContentModel(R.drawable.img_home_collection_sk2, "[SK-II]", "FESTA 특별 이벤트")
    ),
    val preference: List<HomePreferenceModel> = emptyList(),
    val onlineMall: ImmutableList<HomeOnlineItemModel> = persistentListOf(
        HomeOnlineItemModel(imageRes = R.drawable.img_home_onlinemall1, label = "[탬버린즈]", title = "탬버린즈 브랜드 데이"),
        HomeOnlineItemModel(imageRes = R.drawable.img_home_onlinemall2, label = "[Dyson]", title = "공식스토어 리뉴얼 오픈"),
        HomeOnlineItemModel(imageRes = R.drawable.img_home_onlinemall3, label = "[프리 썸머 위크]", title = "여름 신상품 모음")
    ),
    val bottomBanner: HomeBottomBannerModel? = null,

    )

