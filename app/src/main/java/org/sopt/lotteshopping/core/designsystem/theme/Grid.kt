package org.sopt.lotteshopping.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class LotteGrid(
    val margin: Dp,
    val gutter: Dp,
)

val defaultLotteGrid = LotteGrid(
    margin = 20.dp,
    gutter = 10.dp,
)
