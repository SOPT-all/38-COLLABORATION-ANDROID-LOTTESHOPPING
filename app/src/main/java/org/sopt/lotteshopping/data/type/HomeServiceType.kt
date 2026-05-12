package org.sopt.lotteshopping.data.type

import androidx.annotation.DrawableRes
import org.sopt.lotteshopping.R

enum class HomeServiceType(
    @get:DrawableRes val iconRes: Int,
    val label: String,
) {
    RESERVATION(R.drawable.ic_home_reservation, "예약"),
    BRANCH_INFO(R.drawable.ic_home_coupon, "쿠폰"),
    CULTURE_CENTER(R.drawable.ic_home_floor, "층별안내"),
    WEDDING(R.drawable.ic_home_car, "주차"),
    GIFT_CARD(R.drawable.ic_home_receipt, "영수증"),
    COUPON(R.drawable.ic_home_gift, "사은"),
    AI_CHATBOT(R.drawable.ic_home_ai, "AI 챗봇"),
}
