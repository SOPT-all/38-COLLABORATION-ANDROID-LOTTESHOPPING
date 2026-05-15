package org.sopt.lotteshopping.presentation.home.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme
import org.sopt.lotteshopping.presentation.home.model.HomeOnlineItemModel


@Composable
fun HomeOnlineSection(
    onlineItems: List<HomeOnlineItemModel>,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(LotteTheme.colors.white)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = "온라인몰",
                color = LotteTheme.colors.black,
                style = LotteTheme.typography.title.sb18
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_chevron_right),
                contentDescription = null,
                tint = Color.Unspecified
            )

        }

        HorizontalDivider(
            color = LotteTheme.colors.gray100,
            thickness = 0.5.dp
        )

        LazyRow(
            modifier = Modifier.padding(14.dp, bottom = 26.dp),
            contentPadding = PaddingValues(horizontal = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)

        ) {

            items(onlineItems) { item ->
                HomeOnlineCard(
                    imageRes = item.imageRes,
                    label = item.label,
                    title = item.title
                )
            }
        }

    }

}

@Composable
private fun HomeOnlineCard(
    imageRes: Int,
    label: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.width(130.dp)

    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(130.dp)
                .clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = label,
            color = LotteTheme.colors.black,
            style = LotteTheme.typography.body.m14,
        )

        Text(
            text = title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = LotteTheme.colors.black,
            style = LotteTheme.typography.body.m14
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun HomeOnlineSectionPreview() {
    HomeOnlineSection(onlineItems = emptyList())
}

