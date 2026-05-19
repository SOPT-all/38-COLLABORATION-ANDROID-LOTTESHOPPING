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
import org.sopt.lotteshopping.data.repository.PreferenceRepository
import org.sopt.lotteshopping.presentation.home.component.HomeStoreTab
import org.sopt.lotteshopping.presentation.home.component.HomeTabType
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val preferenceRepository: PreferenceRepository,
) : ViewModel() {
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

            preferenceRepository.getPreferences()
                .onSuccess { preference ->
                    _uiState.update { it.copy(preference = preference) }
                }
                .onFailure { Timber.e(it) }

            val mockBottomBanner = HomeBottomBannerModel(1L, "")

            _uiState.update {
                it.copy(
                    topBanners = mockTopBanners,
                    brands = mockBrands,
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
