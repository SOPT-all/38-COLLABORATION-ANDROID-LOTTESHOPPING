package org.sopt.lotteshopping.presentation.main.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.common.naviagtion.MainTabRoute
import org.sopt.lotteshopping.presentation.home.navigation.Home
import org.sopt.lotteshopping.presentation.my.navigation.My
import org.sopt.lotteshopping.presentation.pay.Pay
import org.sopt.lotteshopping.presentation.place.Place
import org.sopt.lotteshopping.presentation.shopping.navigation.Shopping

//TODO 아이콘 에셋 추출 후 변경
enum class MainTab(
    @get:DrawableRes val selectedIconRes: Int,
    @get:DrawableRes val unselectedIconRes: Int,
    @get:StringRes val titleRes: Int,
    val route: MainTabRoute,
) {
    HOME(
        selectedIconRes = R.drawable.ic_launcher_background,
        unselectedIconRes = R.drawable.ic_launcher_background,
        titleRes = R.string.home,
        route = Home,
    ),
    PLACE(
        selectedIconRes = R.drawable.ic_launcher_background,
        unselectedIconRes = R.drawable.ic_launcher_background,
        titleRes = R.string.place,
        route = Place,
    ),
    PAY(
        selectedIconRes = R.drawable.ic_launcher_background,
        unselectedIconRes = R.drawable.ic_launcher_background,
        titleRes = R.string.pay,
        route = Pay,
    ),
    SHOPPING(
        selectedIconRes = R.drawable.ic_launcher_background,
        unselectedIconRes = R.drawable.ic_launcher_background,
        titleRes = R.string.shopping,
        route = Shopping,
    ),
    MY(
        selectedIconRes = R.drawable.ic_launcher_background,
        unselectedIconRes = R.drawable.ic_launcher_background,
        titleRes = R.string.my,
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
