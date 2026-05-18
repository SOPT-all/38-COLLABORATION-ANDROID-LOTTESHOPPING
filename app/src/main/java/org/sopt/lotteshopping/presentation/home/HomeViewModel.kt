package org.sopt.lotteshopping.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.lotteshopping.data.model.banners.HomeBottomBannerModel
import org.sopt.lotteshopping.data.model.banners.HomeTopBannerModel
import org.sopt.lotteshopping.data.model.brands.BeautyBrandModel
import org.sopt.lotteshopping.data.model.preferences.HomePreferenceModel
import org.sopt.lotteshopping.presentation.home.component.HomeStoreTab
import org.sopt.lotteshopping.presentation.home.component.HomeTabType
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<HomeSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    init {
        fetchHomeData()
    }

    private fun fetchHomeData() {
        viewModelScope.launch {
            // TODO: 서버 데이터 연동 로직 추후 목 데이터 삭제
            val mockTopBanners = persistentListOf(
                HomeTopBannerModel(1L, 1, ""),
                HomeTopBannerModel(2L, 1, ""),
                HomeTopBannerModel(3L, 1, "")
            )

            val mockBrands = persistentListOf(
                BeautyBrandModel(1L, "샤넬", ""),
                BeautyBrandModel(2L, "설화수", ""),
                BeautyBrandModel(3L, "입생로랑", ""),
                BeautyBrandModel(4L, "나스", ""),
                BeautyBrandModel(5L, "라라랑", ""),
                BeautyBrandModel(5L, "리리", ""),
                BeautyBrandModel(5L, "로로", ""),
            )

            val mockPreference = listOf(
                HomePreferenceModel(
                    imageUrl = "",
                    title = "[브랜드 읽기] Chanel의 No.5",
                    targetBranch = "전점",
                    startDate = "4.1(수)",
                    endDate = "12.31(동)",
                    id = 0,
                ),
                HomePreferenceModel(
                    imageUrl = "",
                    title = "[스테디셀러] Clinique 기획전",
                    targetBranch = "전점",
                    startDate = "4.1(수)",
                    endDate = "12.31(목)",
                    id = 1,
                ),
            )

            val mockBottomBanner = HomeBottomBannerModel(1L, "")

            _uiState.update {
                it.copy(
                    topBanners = mockTopBanners,
                    brands = mockBrands,
                    preference = mockPreference,
                    bottomBanner = mockBottomBanner
                )
            }
        }
    }

    fun updateHomeTab(tab: HomeTabType) {
        _uiState.update { it.copy(selectedHomeTab = tab) }
    }

    fun updateStoreTab(tab: HomeStoreTab) {
        _uiState.update { it.copy(selectedStoreTab = tab) }
    }

    fun onBrandClick(brand: BeautyBrandModel) {
        viewModelScope.launch {
            if (brand.name == "설화수") {
                _sideEffect.emit(HomeSideEffect.NavigateToBrand(brand.id))
            }
        }
    }
}
