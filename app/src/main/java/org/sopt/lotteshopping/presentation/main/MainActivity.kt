package org.sopt.lotteshopping.presentation.main

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.lotteshopping.core.designsystem.theme.LOTTESHOPPINGTheme
import org.sopt.lotteshopping.presentation.main.component.MainTab


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LOTTESHOPPINGTheme {
                MainScreen(
                    onTabChanged = { enableEdgeToEdge(statusBarStyle = getStatusBarStyle(it)) }
                )
            }
        }
    }

    private fun getStatusBarStyle(tab: MainTab?): SystemBarStyle =
        if (tab == MainTab.HOME) {
            SystemBarStyle.dark(Color.BLACK)
        } else {
            SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT,
            )
        }
}

