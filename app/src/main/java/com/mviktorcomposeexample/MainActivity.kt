package com.mviktorcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.mviktorcomposeexample.presentation.navigation.AppScaffold
import com.mviktorcomposeexample.presentation.ui.theme.MVIKtorComposeExampleTheme
import com.mviktorcomposeexample.presentation.ui.theme.ThemeAwareStatusBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }
            MVIKtorComposeExampleTheme(darkTheme = isDarkTheme) {
                ThemeAwareStatusBar(darkTheme = isDarkTheme)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    initsScreen(onChangeTheme = {
                        isDarkTheme = !isDarkTheme
                    })
                }

            }
        }
    }
}

@Composable
private fun initsScreen(onChangeTheme: () -> Unit = {}) {
    AppScaffold(onChangeTheme = {
        onChangeTheme()
    })
}

