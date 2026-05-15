package org.sopt.lotteshopping.data.model.preferences

// TODO (동연) : api 필드 서버 명세에 따라 변경
data class HomePreferenceModel (
    val id : Long,
    val title: String,
    val targetBranch : String,
    val startDate: String,
    val endDate: String,
    val imageUrl : String
)
