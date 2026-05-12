package org.sopt.lotteshopping.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.colors
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme.typography
import org.sopt.lotteshopping.core.extension.noRippleClickable

enum class HomeTabType(
    val title: String
) {
    DEPARTMENT_STORE("백화점"),
    ONLINE_MALL("온라인몰"),
}

@Composable
fun HomeTopBar(
    selectedTab: HomeTabType,
    onTabClick: (HomeTabType) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(colors.black)
            .padding(vertical = 10.dp, horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_header_menu),
            null,
            tint = colors.white,
        )

        HomeSegmentTab(
            selectedTab = selectedTab,
            onTabClick = onTabClick,
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_header_search),
            null,
            tint = colors.white,
        )
    }
}

@Composable
private fun HomeSegmentTabItem(
    tab: HomeTabType,
    isSelected: Boolean,
    onTabClick: (HomeTabType) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(
                color = if (isSelected) colors.lime500 else colors.gray700,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .noRippleClickable { onTabClick(tab) }
            .widthIn(min = 75.dp)
            .padding(all = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = tab.title,
            style = typography.label.m12,
            color = if (isSelected) colors.black else colors.white
        )
    }
}

@Composable
private fun HomeSegmentTab(
    selectedTab: HomeTabType,
    onTabClick: (HomeTabType) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .background(color = colors.gray700, shape = RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        HomeTabType.entries.forEach { tab ->
            HomeSegmentTabItem(
                tab = tab,
                isSelected = tab == selectedTab,
                onTabClick = onTabClick,
            )
        }
    }
}

@Preview
@Composable
private fun HomeTopBarPreview() {
    LOTTESHOPPINGTheme {
        var selectedTab by remember { mutableStateOf(HomeTabType.DEPARTMENT_STORE) }

        HomeTopBar(
            selectedTab = selectedTab,
            onTabClick = { selectedTab = it }
        )
    }
}
