package com.aslangroup.texnodev.presentaion.navigations

import androidx.annotation.DrawableRes
import com.aslangroup.texnodev.R

sealed class BottomBarScreen(
    @DrawableRes
    val icon: Int,
    val title: String,
    val route: String
){
    object HomeBottom: BottomBarScreen(
        icon = R.drawable.bottom_home_icon,
        title = "Home",
        route = Screen.Home.route
    )
    object CategoryBottom: BottomBarScreen(
        icon = R.drawable.bottom_category_icon,
        title = "Category",
        route = Screen.Category.route
    )
    object FavoriteBottom: BottomBarScreen(
        icon = R.drawable.bottom_favorite_icon,
        title = "Favorite",
        route = Screen.Favorite.route
    )
    object ProfileBottom: BottomBarScreen(
        icon = R.drawable.bottom_profile_icon,
        title = "Profile",
        route = Screen.Profile.route
    )
}
