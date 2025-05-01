package com.rilla.frontend.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rilla.frontend.auth.ui.LoginScreen
import com.rilla.frontend.feed.ui.HomeScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Login.route
    ) {
        composable(NavRoute.Login.route) {
            LoginScreen(onLoginSuccess = {
                navController.navigate(NavRoute.Home.route)
            })
        }
        composable(NavRoute.Home.route) {
            HomeScreen()
        }
    }
}