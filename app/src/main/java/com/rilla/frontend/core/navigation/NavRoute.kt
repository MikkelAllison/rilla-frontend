package com.rilla.frontend.core.navigation

sealed class NavRoute(val route: String) {
    object Login : NavRoute("login")
    object Home : NavRoute("home")
}