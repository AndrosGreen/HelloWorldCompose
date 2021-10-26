package com.example.helloworldcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ListItems.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "Andres"
                    nullable = true
                }
            )
        ){ entry ->
            DetailScreen(name = entry.arguments?.getString("name"))
        }
        composable(route = Screen.ListItems.route){
            ListItems(navController = navController)
        }
        composable(route = Screen.AddItem.route){
            AddItem(navController = navController)
        }
    }
}