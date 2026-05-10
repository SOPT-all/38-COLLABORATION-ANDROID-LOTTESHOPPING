package org.sopt.lotteshopping.presentation.pay

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.lotteshopping.core.common.naviagtion.MainTabRoute
import org.sopt.lotteshopping.presentation.home.HomeRoute

fun NavController.navigateToPay(
    navOptions: NavOptions? = null,
) = navigate(Pay, navOptions)

fun NavGraphBuilder.payGraph(
) {
    composable<Pay> {
    }
}

@Serializable
data object Pay : MainTabRoute
