package com.aslangroup.texnodev.presentaion.screen.favorite

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aslangroup.texnodev.app.theme.Background
import com.aslangroup.texnodev.presentaion.component.AppBarMain
import com.aslangroup.texnodev.presentaion.component.BottomBarMenu
import com.aslangroup.texnodev.presentaion.component.PostComponent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun FavoriteScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { AppBarMain() },
        bottomBar = { BottomBarMenu(navController = navController) },
        containerColor = MaterialTheme.colors.Background
    ) {

    }
}