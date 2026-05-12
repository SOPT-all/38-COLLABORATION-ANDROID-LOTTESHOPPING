package org.sopt.lotteshopping.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.lotteshopping.core.designsystem.theme.LotteTheme

@Composable
fun BannerCard(
    imageRes: Int,
    title: String,
    location: String,
    date: String
) {

    Column(
        modifier = Modifier
            .width(212.dp)
            .background(Color.White)
            .padding(top = 16.dp, bottom = 20.dp)
    )
    {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .width(212.dp)
                .height(212.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = title,
            modifier = Modifier
                .padding(horizontal = 14.dp),
            style = LotteTheme.typography.body.m14,
            color = LotteTheme.colors.black
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 14.dp),
            text = location,
            style = LotteTheme.typography.label.r12,
            color = LotteTheme.colors.gray400
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            modifier = Modifier
                .padding(bottom = 24.dp)
                .padding(horizontal = 14.dp),
            text = date,
            style = LotteTheme.typography.label.r12,
            color = LotteTheme.colors.gray400
        )
    }

}