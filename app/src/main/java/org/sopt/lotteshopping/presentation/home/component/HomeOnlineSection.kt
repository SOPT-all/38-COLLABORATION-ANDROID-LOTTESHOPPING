package org.sopt.lotteshopping.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.data.onlineMallItems


@Composable
fun HomeOnlineSection() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(LotteTheme.colors.white)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp)
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(text = "온라인몰",
            color= LotteTheme.colors.black,
            style= LotteTheme.typography.title.sb18)

            Icon (
                painter = painterResource(id = R.drawable.ic_chevron_right),
                contentDescription = null,
                modifier = Modifier.padding(end = 20.dp)
            )

        }

        HorizontalDivider(
            color = LotteTheme.colors.gray100,
            thickness = 1.dp
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)

        ) {

            items(onlineMallItems) { item ->
                HomeOnlineCard(
                    imageRes = item.imageRes,
                    title = item.title
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomeOnlineSectionPreview() {
    HomeOnlineSection()
}