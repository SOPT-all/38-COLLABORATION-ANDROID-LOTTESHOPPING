package org.sopt.lotteshopping.presentation.home.model

data class OnlineItemModel(
    val imageUrl: String,
    val label : String,
    val title: String,
) {

    companion object{
        val onlineMallItems = listOf(
            OnlineItemModel(
                imageUrl="",
                label= "[탬버린즈]" ,
                title = "탬버린즈 브랜드 데이"
            ) ,
            OnlineItemModel (
                imageUrl="",
                label= "Dyson",
                title ="공식스토어 리뉴얼 오픈"
            ) ,
            OnlineItemModel (
                imageUrl="",
                label= "[프리 썸머 위크]",
                title="여름 신상품 모음"
            )
        )
    }
}
