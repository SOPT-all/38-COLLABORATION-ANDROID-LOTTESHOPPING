package org.sopt.lotteshopping.data

import org.sopt.lotteshopping.R

data class HomeBannerItem (

    val imageRes : Int,
    val title : String,
    val location : String,
    val date: String
)


val bannerItems = listOf(
    HomeBannerItem (
        imageRes= R.drawable.img_home_taste1,
        title= "[브랜드 읽기] Chanel의 No.5",
        location = "전점",
        date = "4.1(수) ~ 12.31(목)"
    ) ,
    HomeBannerItem(
        imageRes = R.drawable.img_home_taste2,
        title = "[스테디셀러] Clinique 기획전",
        location = "전점",
        date = "4.1(수) ~ 12.31(목)"
    )
)

