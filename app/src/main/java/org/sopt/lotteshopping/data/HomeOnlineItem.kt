package org.sopt.lotteshopping.data
import org.sopt.lotteshopping.R

data class HomeOnlineItem(
    val imageRes: Int,
    val title: String,
)

val onlineMallItems = listOf(

    HomeOnlineItem(
        imageRes=R.drawable.img_home_onlinemall1,
        title= "[탬버린즈]\n탬버린즈 브랜드 데이"
    ) ,

    HomeOnlineItem (
        imageRes=R.drawable.img_home_onlinemall2,
        title= "Dyson\n공식스토어 리뉴얼 오픈"
    ) ,
    HomeOnlineItem (
        imageRes=R.drawable.img_home_onlinemall3,
        title= "[프리 썸머 위크]\n여름 신상품 모음"
    )

)