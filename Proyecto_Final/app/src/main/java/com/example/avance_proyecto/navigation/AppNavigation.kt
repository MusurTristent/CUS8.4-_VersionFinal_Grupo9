package com.example.avance_proyecto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.avance_proyecto.ui.view.HomeScreen
import com.example.avance_proyecto.ui.view.InformationScreen
import com.example.avance_proyecto.ui.view.MultasScreen
import com.example.avance_proyecto.ui.view.RegisterScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.homeScreen.route){
        composable(route = AppScreen.homeScreen.route){
            HomeScreen(navController)
        }
        composable(route = AppScreen.registerScreen.route ){
            RegisterScreen(navController)
        }
        composable(route = AppScreen.multasScreen.route+"/{body}" ){
            val body = it.arguments?.getString("body") ?: "0"
            MultasScreen(navController,body)
        }
        composable(route = AppScreen.informationScreen.route ){
            InformationScreen(navController)
        }
    }
}