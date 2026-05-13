package org.sopt.lotteshopping.presentation.home.model
import org.sopt.lotteshopping.R

data class OnlineItemModel(
    val imageRes: Int,
    val label : String,
    val title: String,
) {

    companion object{
        val onlineMallItems = listOf(
            OnlineItemModel(
                imageRes=R.drawable.img_home_onlinemall1,
                label= "[탬버린즈]" ,
                title = "탬버린즈 브랜드 데이"
            ) ,
            OnlineItemModel (
                imageRes=R.drawable.img_home_onlinemall2,
                label= "Dyson",
                title ="공식스토어 리뉴얼 오픈"
            ) ,
            OnlineItemModel (
                imageRes=R.drawable.img_home_onlinemall3,
                label= "[프리 썸머 위크]",
                title="여름 신상품 모음"
            )
        )
    }
}
