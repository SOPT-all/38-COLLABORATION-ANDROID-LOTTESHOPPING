package org.sopt.lotteshopping.presentation.home.component

import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.component.UrlImage
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.data.model.banners.HomeTopBannerModel


class HomeTopBannerState(
    val pagerState: PagerState,
    private val autoScrollDelay: Long = 5000L
) {
    @Composable
    fun HandleAutoScroll() {
        val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

        LaunchedEffect(isDragged) {
            if (!isDragged) {
                while (true) {
                    delay(autoScrollDelay)
                    if (pagerState.pageCount > 0) {
                        val nextPage = pagerState.currentPage + 1
                        pagerState.animateScrollToPage(nextPage)
                    }
                }
            }
        }
    }
}

@Composable
private fun rememberHomeTopBannerState(
    banners: List<HomeTopBannerModel>,
    autoScrollDelay: Long = 5000L
): HomeTopBannerState {
    val pagerState = rememberPagerState(
        initialPage = if (banners.isEmpty()) 0 else (Int.MAX_VALUE / 2) - (Int.MAX_VALUE / 2 % banners.size),
        pageCount = { if (banners.isEmpty()) 0 else Int.MAX_VALUE }
    )
    return remember(pagerState) {
        HomeTopBannerState(pagerState, autoScrollDelay)
    }
}

@Composable
fun HomeTopBanner(
    banners: List<HomeTopBannerModel>,
    modifier: Modifier = Modifier,
    state: HomeTopBannerState = rememberHomeTopBannerState(banners = banners),
) {
    if (banners.isEmpty()) return

    state.HandleAutoScroll()


    Box(modifier = modifier.fillMaxWidth()) {
        HorizontalPager(
            state = state.pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(364f / 174f),
        ) { page ->
            val index = page % banners.size
            UrlImage(
                url = banners[index].imageUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                placeholderDrawable = R.drawable.ic_launcher_background,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeTopBannerPreview() {
    LOTTESHOPPINGTheme {
        val mockBanners = listOf(
            HomeTopBannerModel(1L, ""),
            HomeTopBannerModel(2L, ""),
            HomeTopBannerModel(3L, "")
        )
        HomeTopBanner(banners = mockBanners)
    }
}
