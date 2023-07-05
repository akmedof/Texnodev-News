package com.aslangroup.texnodev.presentaion.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aslangroup.texnodev.app.theme.BackgroundComponent
import com.aslangroup.texnodev.app.theme.BlueMain
import com.aslangroup.texnodev.app.theme.TEXT_SMALE
import com.aslangroup.texnodev.app.theme.TextColor
import com.aslangroup.texnodev.presentaion.navigations.BottomBarScreen

@Composable
fun BottomBarMenu(navController: NavHostController){
    val screens = listOf(
        BottomBarScreen.HomeBottom,
        BottomBarScreen.CategoryBottom,
        BottomBarScreen.FavoriteBottom,
        BottomBarScreen.ProfileBottom,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(backgroundColor = MaterialTheme.colors.BackgroundComponent) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        selectedContentColor = BlueMain,
        unselectedContentColor = MaterialTheme.colors.TextColor,
        label = {
            Text(text = screen.title, fontSize = TEXT_SMALE)
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = "Navigation Icon",
                modifier = Modifier.height(25.dp).width(25.dp),
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
//            navController.popBackStack()
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}