package org.sopt.lotteshopping.presentation.brand.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.R
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme

@Composable
fun ReservationCard(
    title: String,
    period: String,
    modifier: Modifier = Modifier,
    buttonText: String = "예약하기",
) {
    Row(
        modifier = modifier
            .width(320.dp)
            .height(134.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(LotteTheme.colors.gray50)
            .padding(
                horizontal = 14.dp,
                vertical = 12.dp,
            ),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ReservationImage()

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = title,
                    color = LotteTheme.colors.black,
                    style = LotteTheme.typography.label.m12,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = period,
                    color = LotteTheme.colors.black,
                    style = LotteTheme.typography.caption.r10,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            ReservationButton(text = buttonText)
        }
    }
}

@Composable
private fun ReservationImage(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(R.drawable.img_brand_reservation),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
        modifier = modifier
            .size(110.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(LotteTheme.colors.gray50),
    )
}

@Composable
private fun ReservationButton(
    text: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(100.dp))
            .background(LotteTheme.colors.black)
            .padding(
                start = 14.dp,
                top = 6.dp,
                end = 14.dp,
                bottom = 8.dp,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = LotteTheme.colors.white,
            style = LotteTheme.typography.label.m12,
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    widthDp = 320,
    heightDp = 134,
)
@Composable
private fun ReservationCardPreview() {
    LOTTESHOPPINGTheme {
        ReservationCard(
            title = "[설화수] 스킨케어 컨설팅 서비스",
            period = "04.01 (수) ~ 4.30 (목)",
        )
    }
}
