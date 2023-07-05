package com.aslangroup.texnodev.presentaion.navigations

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
    object Favorite: Screen(route = "favorite_screen")
    object Category: Screen(route = "category_screen")
    object Profile: Screen(route = "profile_screen")
    object Login: Screen(route = "login_screen")
    object Register: Screen(route = "register_screen")
    object ForgetPassword: Screen(route = "login_screen")


}
