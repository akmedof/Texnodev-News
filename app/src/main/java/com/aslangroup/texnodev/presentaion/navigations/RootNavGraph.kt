package com.aslangroup.texnodev.presentaion.navigations

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.aslangroup.texnodev.presentaion.screen.category.CategoryScreen
import com.aslangroup.texnodev.presentaion.screen.favorite.FavoriteScreen
import com.aslangroup.texnodev.presentaion.screen.home.HomeScreen
import com.aslangroup.texnodev.presentaion.screen.profile.ProfileScreen
import com.aslangroup.texnodev.presentaion.screen.profile.profile_info.PersonalInfoScreen

@ExperimentalMaterial3Api
@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.MAIN,
    ) {
        navigation(route = Graph.MAIN, startDestination = Screen.Profile.route){
            mainNavGraph(navController)
        }

        navigation(route = Graph.AUTHENTICATION, startDestination = Screen.Login.route){
            authNavGraph(navController)
        }
    }
}

@ExperimentalMaterial3Api
fun NavGraphBuilder.mainNavGraph(navController: NavHostController) {
    mainNavHome(navController)
    mainNavCategory(navController)
    mainNavFavorite(navController)
    mainNavGraphProfile(navController)
}

@ExperimentalMaterial3Api
fun NavGraphBuilder.mainNavHome(navController: NavHostController) {
    composable(route = Screen.Home.route) {
        HomeScreen(navController)
    }
}

@ExperimentalMaterial3Api
fun NavGraphBuilder.mainNavCategory(navController: NavHostController) {
    composable(route = Screen.Category.route) {
        CategoryScreen(navController)
    }
}

@ExperimentalMaterial3Api
fun NavGraphBuilder.mainNavFavorite(navController: NavHostController) {
    composable(route = Screen.Favorite.route) {
        FavoriteScreen(navController)
    }
}

@ExperimentalMaterial3Api
fun NavGraphBuilder.mainNavGraphProfile(navController: NavHostController) {
    mainNavProfile(navController)
    mainNavProfileInfo(navController)
}
@ExperimentalMaterial3Api
fun NavGraphBuilder.mainNavProfile(navController: NavHostController) {
    composable(route = Screen.Profile.route) {
        ProfileScreen(navController)
    }
}
@ExperimentalMaterial3Api
fun NavGraphBuilder.mainNavProfileInfo(navController: NavHostController) {
    composable(route = Screen.PersonalInfo.route) {
        PersonalInfoScreen(navController)
    }
}

