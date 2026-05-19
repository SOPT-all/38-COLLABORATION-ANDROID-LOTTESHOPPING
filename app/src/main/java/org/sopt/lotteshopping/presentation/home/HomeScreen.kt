package org.sopt.lotteshopping.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.persistentListOf
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.component.UrlImage
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.colors
import org.sopt.lotteshopping.data.model.banners.HomeBottomBannerModel
import org.sopt.lotteshopping.data.model.banners.HomeTopBannerModel
import org.sopt.lotteshopping.data.model.brands.HomeBeautyBrandModel
import org.sopt.lotteshopping.data.model.preferences.HomePreferenceModel
import org.sopt.lotteshopping.presentation.home.component.HomeBeautyBrandSection
import org.sopt.lotteshopping.presentation.home.component.HomeBeautyContentSection
import org.sopt.lotteshopping.presentation.home.component.HomeLocationHeader
import org.sopt.lotteshopping.presentation.home.component.HomeOnlineSection
import org.sopt.lotteshopping.presentation.home.component.HomePreferenceSection
import org.sopt.lotteshopping.presentation.home.component.HomeServiceSection
import org.sopt.lotteshopping.presentation.home.component.HomeStoreTab
import org.sopt.lotteshopping.presentation.home.component.HomeTabType
import org.sopt.lotteshopping.presentation.home.component.HomeTopBanner
import org.sopt.lotteshopping.presentation.home.component.HomeTopBar
import org.sopt.lotteshopping.presentation.home.component.HomeUserInfoSection

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    navigateToBrand: (Long) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.sideEffect) {
        viewModel.sideEffect.collect { effect ->
            when (effect) {
                is HomeSideEffect.NavigateToBrand -> navigateToBrand(effect.brandId)
            }
        }
    }
    HomeScreen(
        uiState = uiState,
        onHomeTabClick = viewModel::updateHomeTab,
        onStoreTabClick = viewModel::updateStoreTab,
        onBrandClick = viewModel::onBrandClick,
        modifier = modifier,
    )
}


@Composable
private fun HomeScreen(
    uiState: HomeUiState,
    onHomeTabClick: (HomeTabType) -> Unit,
    onStoreTabClick: (HomeStoreTab) -> Unit,
    onBrandClick: (HomeBeautyBrandModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            HomeTopBar(
                selectedTab = uiState.selectedHomeTab,
                onTabClick = onHomeTabClick,
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .background(color = colors.gray100)
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item { HomeLocationHeader() }

            item {
                HomeTopBanner(banners = uiState.topBanners)
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                HomeBeautyContentSection(
                    contents = uiState.contents,
                    selectedTab = uiState.selectedStoreTab,
                    onTabClick = onStoreTabClick,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                HomeUserInfoSection(
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }

            item {
                HomeServiceSection(
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                HomeBeautyBrandSection(
                    brands = uiState.brands,
                    onBrandClick = onBrandClick,
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Image(
                    painter = painterResource(id = R.drawable.img_home_banner_ad),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                HomePreferenceSection(
                    preferenceItems = uiState.preference,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                HomeOnlineSection(
                    onlineItems = uiState.onlineMall,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                UrlImage(
                    url = uiState.bottomBanner?.imageUrl ?: "",
                    contentDescription = null,
                    placeholderDrawable = R.drawable.ic_launcher_background,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .aspectRatio(160f / 49f)
                )
                Spacer(modifier = Modifier.height(21.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    LOTTESHOPPINGTheme {
        HomeScreen(
            uiState = HomeUiState(
                topBanners = persistentListOf(
                    HomeTopBannerModel(1L, 1, ""),
                    HomeTopBannerModel(2L, 2, ""),
                    HomeTopBannerModel(3L, 3, "")
                ),
                brands = persistentListOf(
                    HomeBeautyBrandModel(1L, "샤넬", ""),
                    HomeBeautyBrandModel(2L, "디올", "")
                ),
                selectedHomeTab = HomeTabType.DEPARTMENT_STORE,
                selectedStoreTab = HomeStoreTab.DEPARTMENT_STORE,
                preference = listOf(
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
                    )
                ),
                bottomBanner = HomeBottomBannerModel(1L, "")
            ),
            onBrandClick = {},
            onHomeTabClick = {},
            onStoreTabClick = {},
        )
    }
}
