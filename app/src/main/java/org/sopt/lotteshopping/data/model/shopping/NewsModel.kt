package org.sopt.lotteshopping.data.model.shopping

data class NewsModel (
    val id: Long,
    val title: String,
    val targetBranch: String,
    val startDate: String,
    val endDate: String,
    val imageUrl: String,
) {
    val hasTargetBranch = targetBranch.isNotBlank()
}
