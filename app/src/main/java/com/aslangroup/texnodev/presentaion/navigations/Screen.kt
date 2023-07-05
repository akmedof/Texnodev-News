package com.aslangroup.texnodev.presentaion.navigations

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
    object Login: Screen(route = "login_screen")
    object Register: Screen(route = "register_screen")
    object ForgetPassword: Screen(route = "login_screen")
}
