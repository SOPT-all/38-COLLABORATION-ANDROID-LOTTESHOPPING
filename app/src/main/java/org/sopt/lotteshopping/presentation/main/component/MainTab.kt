package org.sopt.lotteshopping.presentation.main.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.common.naviagtion.MainTabRoute
import org.sopt.lotteshopping.presentation.home.navigation.Home
import org.sopt.lotteshopping.presentation.my.navigation.My
import org.sopt.lotteshopping.presentation.pay.Pay
import org.sopt.lotteshopping.presentation.place.Place


enum class MainTab(
    @get:DrawableRes val selectedIconRes: Int,
    @get:DrawableRes val unselectedIconRes: Int,
    @get:StringRes val titleRes : Int,
    val route: MainTabRoute,
) {
    HOME(
        selectedIconRes = R.drawable.ic_nav_home_selected,
        unselectedIconRes = R.drawable.ic_nav_home_unselected,
        titleRes= R.string.home,
        route = Home,
    ),
    PLACE(
        selectedIconRes = R.drawable.ic_nav_place_selected,
        unselectedIconRes = R.drawable.ic_nav_place_unselected,
        titleRes= R.string.place,
        route= Place,
    ),
    PAY(
        selectedIconRes = R.drawable.ic_nav_pay_selected,
        unselectedIconRes = R.drawable.ic_nav_pay_unselected,
        titleRes=R.string.pay,
        route= Pay,
    ),
    SHOPPING(
        selectedIconRes = R.drawable.ic_nav_shopping_selected,
        unselectedIconRes = R.drawable.ic_nav_shopping_unselected,
        titleRes= R.string.shopping,
        route= Pay,
    ),
    MY(
        selectedIconRes = R.drawable.ic_nav_my_selected,
        unselectedIconRes = R.drawable.ic_nav_my_unselected,
        titleRes = R.string.my,
        route= My
    );
}
