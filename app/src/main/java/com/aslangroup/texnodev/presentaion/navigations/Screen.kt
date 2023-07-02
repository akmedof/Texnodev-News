package com.aslangroup.texnodev.presentaion.navigations

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
}
