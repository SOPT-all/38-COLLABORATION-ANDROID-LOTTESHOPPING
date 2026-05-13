package org.sopt.lotteshopping.presentation.main.component

import androidx.annotation.DrawableRes
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.common.naviagtion.MainTabRoute
import org.sopt.lotteshopping.presentation.home.navigation.Home
import org.sopt.lotteshopping.presentation.my.navigation.My
import org.sopt.lotteshopping.presentation.pay.Pay
import org.sopt.lotteshopping.presentation.place.Place
import org.sopt.lotteshopping.presentation.shopping.navigation.Shopping


enum class MainTab(
    @get:DrawableRes val selectedIconRes: Int,
    @get:DrawableRes val unselectedIconRes: Int,
    val title: String,
    val route: MainTabRoute,
) {
    HOME(
        selectedIconRes = R.drawable.ic_nav_home_selected,
        unselectedIconRes = R.drawable.ic_nav_home_unselected,
        title = "홈",
        route = Home,
    ),
    PLACE(
        selectedIconRes = R.drawable.ic_nav_place_selected,
        unselectedIconRes = R.drawable.ic_nav_place_unselected,
        title = "지점안내",
        route = Place,
    ),
    PAY(
        selectedIconRes = R.drawable.ic_nav_pay_selected,
        unselectedIconRes = R.drawable.ic_nav_pay_unselected,
        title = "",
        route = Pay,
    ),
    SHOPPING(
        selectedIconRes = R.drawable.ic_nav_shopping_selected,
        unselectedIconRes = R.drawable.ic_nav_shopping_unselected,
        title = "쇼핑정보",
        route = Shopping,
    ),
    MY(
        selectedIconRes = R.drawable.ic_nav_my_selected,
        unselectedIconRes = R.drawable.ic_nav_my_unselected,
        title = "MY",
        route = My,
    );

    companion object {
        fun find(predicate: (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        fun contains(predicate: (MainTabRoute) -> Boolean): Boolean {
            return entries.any { predicate(it.route) }
        }
    }
}
