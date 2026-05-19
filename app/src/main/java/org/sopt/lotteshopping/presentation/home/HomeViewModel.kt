package org.sopt.lotteshopping.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.lotteshopping.data.model.banners.HomeBottomBannerModel
import org.sopt.lotteshopping.data.model.brands.HomeBeautyBrandModel
import org.sopt.lotteshopping.data.model.preferences.HomePreferenceModel
import org.sopt.lotteshopping.data.repository.BannersRepository
import org.sopt.lotteshopping.data.repository.BrandsRepository
import org.sopt.lotteshopping.presentation.home.component.HomeStoreTab
import org.sopt.lotteshopping.presentation.home.component.HomeTabType
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bannersRepository: BannersRepository,
    private val brandsRepository: BrandsRepository,
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
            bannersRepository.getHomeTopBanners()
                .onSuccess { banners ->
                    _uiState.update { it.copy(topBanners = banners.toImmutableList()) }
                }
                .onFailure { Timber.e(it) }

            brandsRepository.getHomeBrands()
                .onSuccess { brands ->
                    _uiState.update { it.copy(brands = brands.toImmutableList()) }
                }
                .onFailure { Timber.e(it) }

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

    fun onBrandClick(brand: HomeBeautyBrandModel) {
        viewModelScope.launch {
            if (brand.name == "설화수") {
                _sideEffect.emit(HomeSideEffect.NavigateToBrand(brand.id))
            }
        }
    }
}
