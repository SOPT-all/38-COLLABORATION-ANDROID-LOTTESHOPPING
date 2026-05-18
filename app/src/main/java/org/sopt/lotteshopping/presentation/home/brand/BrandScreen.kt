package org.sopt.lotteshopping.presentation.home.brand

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BrandRoute(
    innerPadding: PaddingValues,
) {
    BrandScreen(
        innerPadding = innerPadding,
    )
}

@Composable
private fun BrandScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    BrandContent(
        modifier = modifier.padding(innerPadding),
    )
}
