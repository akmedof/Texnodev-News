package com.aslangroup.texnodev.presentaion.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aslangroup.texnodev.R
import com.aslangroup.texnodev.app.theme.Background
import com.aslangroup.texnodev.app.theme.BackgroundComponent
import com.aslangroup.texnodev.app.theme.BlueMain
import com.aslangroup.texnodev.app.theme.CheckActive
import com.aslangroup.texnodev.app.theme.CheckInActive
import com.aslangroup.texnodev.app.theme.PADDING_DEFAULT
import com.aslangroup.texnodev.app.theme.PADDING_MEDIUM
import com.aslangroup.texnodev.app.theme.PADDING_SMALL
import com.aslangroup.texnodev.app.theme.RADIUS_CYCLE
import com.aslangroup.texnodev.app.theme.RADIUS_SMALE
import com.aslangroup.texnodev.app.theme.TEXT_LARGE
import com.aslangroup.texnodev.app.theme.TEXT_MEDIUM
import com.aslangroup.texnodev.app.theme.TEXT_MEDIUM_PLUS
import com.aslangroup.texnodev.app.theme.TEXT_SMALE
import com.aslangroup.texnodev.app.theme.TextColor
import com.aslangroup.texnodev.app.theme.TextEmptyColor
import com.aslangroup.texnodev.app.theme.White
import com.aslangroup.texnodev.presentaion.component.AppBarMain
import com.aslangroup.texnodev.presentaion.component.BottomBarMenu
import com.aslangroup.texnodev.presentaion.component.PostComponent
import com.aslangroup.texnodev.presentaion.navigations.Graph

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
        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxSize()
                .padding(horizontal = PADDING_DEFAULT)
        ) {
            item {
                ProfileView(
                    fullName = "Broklyn Simmons",
                    email = "broklynsimmons@gmail.com",
                )
                Spacer(modifier = modifier.padding(top = PADDING_MEDIUM))
                ProfileMenu(
                    label = "Personal info",
                    descriptions = "Name, Surname, Email",
                    icon = R.drawable.bottom_profile_icon,
                    onClick = {}
                )
                ProfileSwitchMenu(
                    label = "Dark mode",
                    descriptions = "Dark and light mode switch",
                    icon = R.drawable.dark_mode_icon
                )
                ProfileMenu(
                    label = "Change password",
                    descriptions = "Forgot, change password",
                    icon = R.drawable.change_password,
                    onClick = {}
                )
                ProfileMenu(
                    label = "Notification",
                    descriptions = "App news notification",
                    icon = R.drawable.notification_icon,
                    onClick = {}
                )
                ProfileMenu(
                    label = "Language",
                    descriptions = "A-Z all languages",
                    icon = R.drawable.langiage_icon,
                    onClick = {}
                )
                ProfileMenu(
                    label = "App version",
                    descriptions = "Version: 8.47.7 (16) 8.0.1-001",
                    icon = R.drawable.app_version_icon,
                    onClick = {}
                )
                ProfileMenu(
                    label = "Logout",
                    icon = R.drawable.log_out_icon,
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(Graph.AUTHENTICATION)
                    }
                )
            }
        }
    }
}

@Composable
private fun ProfileView(
    fullName: String,
    email: String,
    avatar: String = "",
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(PADDING_MEDIUM),
        modifier = modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(RADIUS_SMALE))
            .background(MaterialTheme.colors.BackgroundComponent)
            .padding(PaddingValues(PADDING_MEDIUM))
    ) {
        Image(
            painter = painterResource(id = R.drawable.test_avatar),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(75.dp)
                .clip(shape = RoundedCornerShape(RADIUS_CYCLE))
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(PADDING_DEFAULT),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = fullName,
                color = MaterialTheme.colors.TextColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = TEXT_LARGE
            )
            Text(
                text = email,
                color = MaterialTheme.colors.TextColor,
                fontWeight = FontWeight.W300,
                fontSize = TEXT_MEDIUM
            )
        }
    }
}

@Composable
private fun ProfileMenu(
    label: String,
    descriptions: String = "",
    icon: Int,
    onClick: () -> Unit,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(top = PADDING_DEFAULT)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(RADIUS_SMALE))
            .background(MaterialTheme.colors.BackgroundComponent)
            .clickable(onClick = onClick)
            .padding(PaddingValues(PADDING_MEDIUM))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(PADDING_MEDIUM)
        ) {
            Box(
                modifier = modifier
                    .size(40.dp)
                    .clip(shape = RoundedCornerShape(RADIUS_SMALE))
                    .background(MaterialTheme.colors.Background)
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "",
                    tint = BlueMain,
                    modifier = modifier
                        .size(25.dp)
                        .align(Alignment.Center)
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(PADDING_SMALL),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = label,
                    color = MaterialTheme.colors.TextColor,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = TEXT_MEDIUM
                )
                if (descriptions.isNotEmpty())
                    Text(
                        text = descriptions,
                        color = MaterialTheme.colors.TextColor,
                        fontWeight = FontWeight.W300,
                        fontSize = TEXT_SMALE
                    )
            }
        }
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right_icon),
                contentDescription = "",
                tint = MaterialTheme.colors.TextColor,
                modifier = modifier.size(25.dp)
            )
    }
}

@Composable
private fun ProfileSwitchMenu(
    label: String,
    descriptions: String,
    icon: Int,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(top = PADDING_DEFAULT)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(RADIUS_SMALE))
            .background(MaterialTheme.colors.BackgroundComponent)
            .padding(PaddingValues(PADDING_MEDIUM))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(PADDING_MEDIUM)
        ) {
            Box(
                modifier = modifier
                    .size(40.dp)
                    .clip(shape = RoundedCornerShape(RADIUS_SMALE))
                    .background(MaterialTheme.colors.Background)
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "",
                    tint = BlueMain,
                    modifier = modifier
                        .size(25.dp)
                        .align(Alignment.Center)
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(PADDING_SMALL),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = label,
                    color = MaterialTheme.colors.TextColor,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = TEXT_MEDIUM
                )
                Text(
                    text = descriptions,
                    color = MaterialTheme.colors.TextColor,
                    fontWeight = FontWeight.W300,
                    fontSize = TEXT_SMALE
                )
            }
        }
        CustomSwitchButton(
            checked = false,
            onCheckedChange = {},
        )
    }
}

@Composable
fun CustomSwitchButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var switchState by remember { mutableStateOf(checked) }

    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(RADIUS_CYCLE))
            .clickable {
                switchState = !switchState
                onCheckedChange(switchState)
            }
//            .padding(PaddingValues(PADDING_SMALL))
    ) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .clip(CircleShape)
                .background(if (switchState) CheckActive else CheckInActive)
                .padding(PaddingValues(PADDING_SMALL))
        ) {
            Box(
                modifier = Modifier
                    .size(22.5.dp)
                    .border(
                        width = 0.5.dp,
                        color = MaterialTheme.colors.TextEmptyColor.copy(0.25f),
                        shape = CircleShape
                    )
                    .clip(CircleShape)
                    .align(if (switchState) Alignment.CenterEnd else Alignment.CenterStart)
                    .background(White)
            )
        }
    }
}