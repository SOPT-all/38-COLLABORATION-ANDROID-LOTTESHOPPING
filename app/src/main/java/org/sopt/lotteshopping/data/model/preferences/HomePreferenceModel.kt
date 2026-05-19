package org.sopt.lotteshopping.data.model.preferences

data class HomePreferenceModel (
    val id : Long,
    val title: String,
    val targetBranch : String,
    val startDate: String,
    val endDate: String,
    val imageUrl : String
)
