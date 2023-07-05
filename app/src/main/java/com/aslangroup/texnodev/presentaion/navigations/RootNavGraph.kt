package com.aslangroup.texnodev.presentaion.navigations

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.aslangroup.texnodev.app.theme.Background
import com.aslangroup.texnodev.presentaion.screen.auth.login.LoginScreen
import com.aslangroup.texnodev.presentaion.screen.home.HomeScreen

@ExperimentalMaterial3Api
@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION,
    ) {
        navigation(route = Graph.MAIN, startDestination = Screen.Home.route){
            mainNavGraph(navController)
        }

        navigation(route = Graph.AUTHENTICATION, startDestination = Screen.Register.route){
            authNavGraph(navController)
        }
    }
}

@ExperimentalMaterial3Api
fun NavGraphBuilder.mainNavGraph(navController: NavHostController) {
    mainNavHome(navController)
}

@ExperimentalMaterial3Api
fun NavGraphBuilder.mainNavHome(navController: NavHostController) {
    composable(route = Screen.Home.route) {
        HomeScreen()
    }
}

