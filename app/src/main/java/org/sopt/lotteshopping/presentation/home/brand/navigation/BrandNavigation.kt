package org.sopt.lotteshopping.presentation.home.brand.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.lotteshopping.core.common.naviagtion.Route
import org.sopt.lotteshopping.presentation.home.brand.BrandRoute

fun NavController.navigateToBrand(
    brandId: Long,
    navOptions: NavOptions? = null,
) = navigate(Brand(brandId), navOptions)

fun NavGraphBuilder.brandGraph(
    innerPadding: PaddingValues,
    navigateUp: () -> Unit,
    navigateHome: () -> Unit,
) {
    composable<Brand> {
        BrandRoute(
            innerPadding = innerPadding,
            navigateUp = navigateUp,
            navigateHome = navigateHome,
        )
    }
}

@Serializable
data class Brand(val id: Long) : Route
