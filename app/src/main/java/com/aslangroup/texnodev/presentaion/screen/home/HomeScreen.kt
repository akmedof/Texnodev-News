package com.aslangroup.texnodev.presentaion.screen.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aslangroup.texnodev.app.theme.Background
import com.aslangroup.texnodev.app.theme.BackgroundComponent
import com.aslangroup.texnodev.presentaion.component.AppBarMain
import com.aslangroup.texnodev.presentaion.component.PostComponent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { AppBarMain() },
        containerColor = MaterialTheme.colors.Background
    ) {
        LazyColumn(modifier = modifier.padding(horizontal = 10.dp)) {
            items(5) {
                PostComponent()
            }
        }
    }
}