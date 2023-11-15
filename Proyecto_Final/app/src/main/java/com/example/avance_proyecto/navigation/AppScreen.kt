package com.example.avance_proyecto.navigation

sealed class AppScreen(val route: String){
    object homeScreen: AppScreen("home")
    object multasScreen: AppScreen("multas")
    object registerScreen: AppScreen("register")
    object informationScreen: AppScreen("information")
}
