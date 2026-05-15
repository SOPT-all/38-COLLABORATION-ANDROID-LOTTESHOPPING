package org.sopt.lotteshopping.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
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
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.colors
import org.sopt.lotteshopping.data.model.banners.HomeTopBannerModel
import org.sopt.lotteshopping.data.model.brands.BeautyBrandModel
import org.sopt.lotteshopping.presentation.home.component.HomeBeautyBrandSection
import org.sopt.lotteshopping.presentation.home.component.HomeBeautyContentSection
import org.sopt.lotteshopping.presentation.home.component.HomeLocationHeader
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
    onBrandClick: (BeautyBrandModel) -> Unit,
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
                HomeTopBanner(
                    banners = uiState.banners,
                )
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
                banners = listOf(
                    HomeTopBannerModel(1L, 1, ""),
                    HomeTopBannerModel(2L, 2, ""),
                    HomeTopBannerModel(3L, 3, "")
                ),
                brands = listOf(
                    BeautyBrandModel(1L, "샤넬", ""),
                    BeautyBrandModel(2L, "디올", "")
                ),
                selectedHomeTab = HomeTabType.DEPARTMENT_STORE,
                selectedStoreTab = HomeStoreTab.DEPARTMENT_STORE
            ),
            onBrandClick = {},
            onHomeTabClick = {},
            onStoreTabClick = {},
        )
    }
}
