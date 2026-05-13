package org.sopt.lotteshopping.presentation.main.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.core.extension.noRippleClickable


@Composable
fun MainBottomBar(
    tabs: ImmutableList<MainTab>,
    currentTab: MainTab?,
    onTabSelected: (MainTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(color = LotteTheme.colors.gray50),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEach { tab ->
                val selectedIcon =
                    if (tab == currentTab) tab.selectedIconRes else tab.unselectedIconRes
                val selectedColor =
                    if (tab == currentTab) LotteTheme.colors.black else LotteTheme.colors.gray400

                MainNavigationBarItem(
                    tab = tab,
                    onClick = { onTabSelected(tab) },
                    selectedIcon = selectedIcon,
                    selectedColor = selectedColor,
                )
            }
        }

        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(14.dp)
                    .background(color = LotteTheme.colors.gray50)
        )
    }
}

@Composable
private fun MainNavigationBarItem(
    tab: MainTab,
    onClick: () -> Unit,
    @DrawableRes selectedIcon: Int,
    selectedColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .semantics(mergeDescendants = true) { role = Role.Tab }
                .width(72.dp)
                .height(68.dp)
                .noRippleClickable(onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (tab == MainTab.PAY) {
            Spacer(modifier = Modifier.height(15.dp))
            Icon(
                imageVector = ImageVector.vectorResource(selectedIcon),
                contentDescription = tab.title,
                tint = selectedColor,
                modifier = Modifier.size(38.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
        } else {
            Icon(
                imageVector = ImageVector.vectorResource(selectedIcon),
                contentDescription = tab.title,
                tint = selectedColor,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = tab.title,
                color = selectedColor,
                style = LotteTheme.typography.caption.r10
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainBottomBarPreview() {
    LOTTESHOPPINGTheme {
        MainBottomBar(
            tabs = MainTab.entries.toImmutableList(),
            currentTab = MainTab.HOME,
            onTabSelected = {},
        )
    }
}
