package org.sopt.lotteshopping.presentation.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.compose.NavHost
import kotlinx.collections.immutable.toImmutableList
import org.sopt.lotteshopping.presentation.home.brand.navigation.brandGraph
import org.sopt.lotteshopping.presentation.home.brand.navigation.navigateToBrand
import org.sopt.lotteshopping.presentation.home.navigation.homeGraph
import org.sopt.lotteshopping.presentation.main.component.MainBottomBar
import org.sopt.lotteshopping.presentation.main.component.MainTab
import org.sopt.lotteshopping.presentation.my.navigation.myGraph
import org.sopt.lotteshopping.presentation.pay.payGraph
import org.sopt.lotteshopping.presentation.shopping.navigation.shoppingGraph

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator(),
) {
    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = navigator.showBottomBar(),
                enter = fadeIn() + slideIn { IntOffset(0, it.height) },
                exit = fadeOut() + slideOut { IntOffset(0, it.height) },
            ) {
                MainBottomBar(
                    tabs = MainTab.entries.toImmutableList(),
                    currentTab = navigator.currentTab,
                    onTabSelected = navigator::navigate,
                    modifier = Modifier.navigationBarsPadding(),
                )
            }
        },
        //TODO DS 세팅 후 변경
        containerColor = Color.White,
    ) { innerPadding ->
        MainNavHost(
            navigator = navigator,
            innerPadding = innerPadding,
        )
    }
}

@Composable
private fun MainNavHost(
    innerPadding: PaddingValues,
    navigator: MainNavigator,
) {
    NavHost(
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
        navController = navigator.navController,
        startDestination = navigator.startDestination,
    ) {
        homeGraph(
            innerPadding = innerPadding,
            navigateToBrand = navigator.navController::navigateToBrand,
        )

        brandGraph(navigateUp = navigator::navigateUp)
        payGraph()

        shoppingGraph()

        myGraph()
    }
}
