package com.mviktorcomposeexample.presentation.navigation

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mviktorcomposeexample.presentation.screen.details.DetailsScreen
import com.mviktorcomposeexample.presentation.screen.home.HomeScreen

@Composable
fun AppScaffold(onChangeTheme: () -> Unit){
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            onChangeTheme = {
                onChangeTheme()
            }
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier= Modifier,
    onChangeTheme: () -> Unit
){
    NavHost(
        navController = navController,
        startDestination = Screens.HOME.route,
        modifier = modifier,
    ){
        composable(Screens.HOME.route) {
            HomeScreen(
                onArticlesClick = { url ->
                    navController.navigate("${Screens.DETAILS.route}/${Uri.encode(url)}")},
                onChangeTheme = {
                    onChangeTheme()
                })
                }



    composable(
        route = "${Screens.DETAILS.route}/{url}",
        arguments = listOf(navArgument("url") { type = NavType.StringType })
    ) { backStackEntry ->
        val url = backStackEntry.arguments?.getString("url") ?: ""
        DetailsScreen(url, onBackClick = {
            navController.popBackStack()
        })
    }
    }
}