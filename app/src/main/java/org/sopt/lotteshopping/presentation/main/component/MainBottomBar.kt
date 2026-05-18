package org.sopt.lotteshopping.presentation.main.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
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
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(68.dp)
            .background(color = LotteTheme.colors.gray50)
            .navigationBarsPadding(),
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
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 14.dp),
            )
        }
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
        modifier = modifier
            .semantics(mergeDescendants = true) { role = Role.Tab }
            .noRippleClickable(onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(selectedIcon),
            contentDescription = stringResource(tab.titleRes),
            tint = selectedColor,
            modifier = Modifier.size(if (tab == MainTab.PAY) 38.dp else 24.dp)
        )

        if (tab != MainTab.PAY) {
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = stringResource(tab.titleRes),
                color = selectedColor,
                style = LotteTheme.typography.caption.r10,
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
