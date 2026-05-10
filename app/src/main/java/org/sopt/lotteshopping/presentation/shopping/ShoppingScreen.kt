package org.sopt.lotteshopping.presentation.shopping

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShoppingRoute() {
    ShoppingScreen()
}

@Composable
private fun ShoppingScreen(
    modifier: Modifier = Modifier,
) {
        Text("쇼핑")
}
