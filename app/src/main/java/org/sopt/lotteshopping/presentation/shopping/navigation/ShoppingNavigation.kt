package org.sopt.lotteshopping.presentation.shopping.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.lotteshopping.core.common.naviagtion.MainTabRoute
import org.sopt.lotteshopping.presentation.shopping.ShoppingRoute

fun NavController.navigateToShopping(
    navOptions: NavOptions? = null,
) = navigate(Shopping, navOptions)

fun NavGraphBuilder.shoppingGraph(
) {
    composable<Shopping> {
        ShoppingRoute()
    }
}

@Serializable
data object Shopping : MainTabRoute
