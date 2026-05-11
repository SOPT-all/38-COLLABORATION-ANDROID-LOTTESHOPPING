package org.sopt.lotteshopping.presentation.home.component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R

@Composable
fun HomeBottomBar() {
    NavigationBar(
        containerColor = Color(0xFFF5F6F6) ,
        modifier = Modifier.height(82.dp)
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_nav_home_selected),
                    contentDescription = null
                )

            },
            label = { Text("홈") },
            colors = NavigationBarItemDefaults.colors(
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Black,
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Black
            )
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_nav_place_unselected),
                    contentDescription = null
                )

            },
            label = { Text("지점안내") },
            colors = NavigationBarItemDefaults.colors(
                selectedTextColor = Color(0xFF797979),
                unselectedTextColor = Color(0xFF797979),
                selectedIconColor = Color(0xFF797979),
                unselectedIconColor = Color(0xFF797979)
            )

        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            alwaysShowLabel = false,
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_nav_pay_unselected),
                    contentDescription = null
                )
            },
            label= { Text("")}
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_nav_shopping_unselected),
                    contentDescription = null
                )
            } ,
            label = { Text("쇼핑정보") },
            colors = NavigationBarItemDefaults.colors(
                selectedTextColor = Color(0xFF797979),
                unselectedTextColor = Color(0xFF797979),
                selectedIconColor = Color(0xFF797979),
                unselectedIconColor = Color(0xFF797979)
            )
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_nav_my_unselected),
                    contentDescription = null
                )
            } ,
            label = { Text("MY") },
            colors = NavigationBarItemDefaults.colors(
                selectedTextColor = Color(0xFF797979),
                unselectedTextColor = Color(0xFF797979),
                selectedIconColor = Color(0xFF797979),
                unselectedIconColor = Color(0xFF797979)
            )
        )



    }

}

@Preview
@Composable
fun HomeBottomBarPreview() {
    HomeBottomBar()
}


