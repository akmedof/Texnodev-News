package com.aslangroup.texnodev.presentaion.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aslangroup.texnodev.R
import com.aslangroup.texnodev.app.theme.Background
import com.aslangroup.texnodev.app.theme.PADDING_DEFAULT
import com.aslangroup.texnodev.app.theme.PADDING_MEDIUM
import com.aslangroup.texnodev.app.theme.RADIUS_CYCLE
import com.aslangroup.texnodev.app.theme.TEXT_MEDIUM
import com.aslangroup.texnodev.app.theme.TextColor
import com.aslangroup.texnodev.presentaion.component.AppBarMain
import com.aslangroup.texnodev.presentaion.component.BottomBarMenu
import com.aslangroup.texnodev.presentaion.component.PostComponent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ProfileScreen(
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

@Composable
private fun ProfileView(
    fullName: String,
    email: String,
    avatar: String = "",
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(PADDING_MEDIUM)
    ) {
        Image(
            painter = painterResource(id = R.drawable.test_avatar),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(100.dp)
                .clip(shape = RoundedCornerShape(RADIUS_CYCLE))
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(PADDING_DEFAULT),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "Aşağıdakı xanaları dolduraraq aplikasiyaya keçid edin.",
                color = MaterialTheme.colors.TextColor,
                fontWeight = FontWeight.W400,
                fontSize = TEXT_MEDIUM
            )
        }
    }
}