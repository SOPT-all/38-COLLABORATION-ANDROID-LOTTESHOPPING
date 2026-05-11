package org.sopt.lotteshopping.presentation.home.component

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeOnlineCard (
    imageRes :Int,
    title:String
) {
    Column(
        modifier= Modifier
            .width(130.dp)
            .padding(top=14.dp,bottom=26.dp)
    )
    {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .width(130.dp)
                .height(130.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = title,
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight= FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 4.dp)
                .padding(bottom=26.dp)
        )

    }
}