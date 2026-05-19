package org.sopt.lotteshopping.presentation.home.brand

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.sopt.lotteshopping.presentation.home.brand.component.BrandContent

@Composable
fun BrandRoute(
    innerPadding: PaddingValues,
    navigateUp: () -> Unit,
) {
    BrandContent(
        onBackClick = navigateUp,
        modifier = Modifier.padding(innerPadding),
    )
}
