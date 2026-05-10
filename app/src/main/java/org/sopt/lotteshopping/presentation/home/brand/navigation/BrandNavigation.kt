package org.sopt.lotteshopping.presentation.home.brand.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.lotteshopping.core.common.naviagtion.Route
import org.sopt.lotteshopping.presentation.home.brand.BrandRoute

fun NavController.navigateToBrand(
    navOptions: NavOptions? = null,
) = navigate(Brand, navOptions)

fun NavGraphBuilder.brandGraph(
    navigateUp: () -> Unit,
) {
    composable<Brand> {
        BrandRoute()
    }
}

@Serializable
data object Brand : Route
