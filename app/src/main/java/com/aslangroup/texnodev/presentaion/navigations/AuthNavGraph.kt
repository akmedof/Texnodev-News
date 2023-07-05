package com.aslangroup.texnodev.presentaion.navigations

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aslangroup.texnodev.presentaion.screen.auth.login.LoginScreen
import com.aslangroup.texnodev.presentaion.screen.auth.register.RegisterScreen

@ExperimentalMaterial3Api
fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    authNavLogin(navController)
    authNavRegister(navController)
}

@ExperimentalMaterial3Api
fun NavGraphBuilder.authNavLogin(navController: NavHostController) {
    composable(route = Screen.Login.route) {
        LoginScreen(navController)
    }
}

@ExperimentalMaterial3Api
fun NavGraphBuilder.authNavRegister(navController: NavHostController) {
    composable(route = Screen.Register.route) {
        RegisterScreen(navController)
    }
}