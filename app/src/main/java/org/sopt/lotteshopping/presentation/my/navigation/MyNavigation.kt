package org.sopt.lotteshopping.presentation.my.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.lotteshopping.core.common.naviagtion.MainTabRoute

fun NavController.navigateToMy(
    navOptions: NavOptions? = null,
) = navigate(My, navOptions)

fun NavGraphBuilder.myGraph(
) {
    composable<My> {
    }
}

@Serializable
data object My : MainTabRoute
