package org.sopt.lotteshopping.presentation.place

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.lotteshopping.core.common.naviagtion.MainTabRoute

fun NavController.navigateToPlace(
    navOptions: NavOptions? = null,
) = navigate(Place, navOptions)

fun NavGraphBuilder.placeGraph(
) {
    composable<Place>{
    }
}

@Serializable
data object Place : MainTabRoute
