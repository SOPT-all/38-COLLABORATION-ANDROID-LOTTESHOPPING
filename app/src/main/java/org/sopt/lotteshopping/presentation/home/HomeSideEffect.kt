package org.sopt.lotteshopping.presentation.home

sealed interface HomeSideEffect {
    data class NavigateToBrand(val brandId: Long) : HomeSideEffect
}
