package org.sopt.lotteshopping.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.lotteshopping.presentation.home.brand.navigation.Brand
import org.sopt.lotteshopping.presentation.home.navigation.Home
import org.sopt.lotteshopping.presentation.home.navigation.navigateToHome
import org.sopt.lotteshopping.presentation.main.component.MainTab
import org.sopt.lotteshopping.presentation.shopping.navigation.navigateToShopping

class MainNavigator(
    val navController: NavHostController,
) {
    val startDestination = Home

    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState()
            .value
            ?.destination

    val currentTab: MainTab?
        @Composable get() = MainTab.entries.find { tab ->
            currentDestination?.hasRoute(tab.route::class) == true
        } ?: if (currentDestination?.hasRoute(Brand::class) == true) MainTab.HOME else null

    fun navigate(tab: MainTab) {
        val navOptions =
            navOptions {
                navController.currentDestination?.route?.let {
                    popUpTo(it) {
                        saveState = true
                        inclusive = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }

        when (tab) {
            MainTab.HOME -> navController.navigateToHome(navOptions = navOptions)
            MainTab.PLACE -> {} // TODO: 디자인 미구현 사항
            MainTab.PAY -> {} // TODO: 디자인 미구현 사항
            MainTab.SHOPPING -> navController.navigateToShopping(navOptions = navOptions)
            MainTab.MY -> {} // TODO: 디자인 미구현 사항
        }
    }

    fun navigateUp() = navController.navigateUp()

}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator =
    remember(navController) {
        MainNavigator(navController)
    }
