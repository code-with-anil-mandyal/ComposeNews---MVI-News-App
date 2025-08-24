package com.mviktorcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.mviktorcomposeexample.presentation.navigation.AppScaffold
import com.mviktorcomposeexample.presentation.ui.theme.MVIKtorComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVIKtorComposeExampleTheme {
                initsScreen()
            }
        }
    }
}

@Composable
private fun initsScreen() {
    AppScaffold()
}

