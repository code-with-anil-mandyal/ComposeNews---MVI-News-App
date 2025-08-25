package com.mviktorcomposeexample.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun ThemeAwareStatusBar(darkTheme: Boolean) {
    val systemUiController = rememberSystemUiController()
    val statusBarColor = if (darkTheme) Color.Black else Color.White
    val useDarkIcons = !darkTheme // true = dark icons, false = light icons

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = useDarkIcons
        )
    }
}