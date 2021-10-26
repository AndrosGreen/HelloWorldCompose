package com.example.helloworldcompose

import androidx.navigation.NavArgs

sealed class Screen(val route: String){
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")
    object ListItems : Screen("lista_items")
    object AddItem : Screen("add_item")

    fun withArgs( vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
