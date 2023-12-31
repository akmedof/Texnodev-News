package com.aslangroup.texnodev.presentaion.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aslangroup.texnodev.R
import com.aslangroup.texnodev.app.theme.*
import com.aslangroup.texnodev.app.theme.BackgroundComponent
import com.aslangroup.texnodev.app.theme.PADDING_DEFAULT
import com.aslangroup.texnodev.app.theme.RADIUS_MEDIUM
import com.aslangroup.texnodev.app.theme.RADIUS_SMALE

@Composable
fun AppBarMain(
    modifier: Modifier = Modifier
) {
    val logo =
        if (!isSystemInDarkTheme()) R.drawable.texnodev_logo_white else R.drawable.texnodev_logo_dark
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(horizontal = PADDING_DEFAULT)
            .padding(top = PADDING_SMALL)
            .fillMaxWidth()
            .height(56.dp)
            .clip(shape = RoundedCornerShape(RADIUS_SMALE / 2))
            .background(MaterialTheme.colors.BackgroundComponent)
            .padding(PaddingValues(horizontal = PADDING_DEFAULT))
    ) {
        Image(painter = painterResource(id = logo), contentDescription = "", modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(PADDING_DEFAULT),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AppActionIcon(icon = R.drawable.search_icon, color = BlueMain, onClick = {})
            AppActionIcon(icon = R.drawable.notification_icon, color = BlueMain, onClick = {})
        }
    }
}

@Composable
fun AppBarDefault(
    label: String,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Box(
        modifier = modifier
            .padding(horizontal = PADDING_DEFAULT)
            .padding(top = PADDING_SMALL)
            .fillMaxWidth()
            .height(56.dp)
            .clip(shape = RoundedCornerShape(RADIUS_SMALE / 2))
            .background(MaterialTheme.colors.BackgroundComponent)
            .padding(PaddingValues(horizontal = PADDING_DEFAULT))
    ) {
        AppActionIcon(
            icon = R.drawable.ic_arrow_left_icon,
            color = BlueMain,
            iconSize = 35,
            modifier = modifier.align(Alignment.CenterStart),
            onClick = onBackClick
        )
        Text(
            text = label,
            fontSize = TEXT_LARGE,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.TextColor,
            letterSpacing = 2.sp,
            modifier = modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun AppBarAuth(
    onBack: Boolean = false,
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier
) {
    val logo =
        if (!isSystemInDarkTheme()) R.drawable.texnodev_logo_white else R.drawable.texnodev_logo_dark
    Box(
        modifier = modifier
            .padding(horizontal = PADDING_DEFAULT)
            .padding(top = PADDING_SMALL)
            .fillMaxWidth()
            .height(56.dp)
            .clip(shape = RoundedCornerShape(RADIUS_SMALE / 2))
            .background(MaterialTheme.colors.BackgroundComponent)
            .padding(PaddingValues(horizontal = PADDING_DEFAULT))
    ) {
        if (onBack)
            AppActionIcon(
                icon = R.drawable.ic_arrow_left_icon,
                color = BlueMain,
                iconSize = 30,
                modifier = modifier.align(Alignment.CenterStart),
                onClick = {}
            )

        Image(
            painter = painterResource(id = logo),
            contentDescription = "",
            modifier
                .height(20.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun AppActionIcon(
    icon: Int,
    color: Color,
    iconSize: Int = 20,
    onClick: () -> Unit,
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(RADIUS_CYCLE))
            .clickable(onClick = onClick)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "",
            tint = color,
            modifier = modifier
                .padding(PaddingValues(PADDING_SMALL))
                .size(iconSize.dp)
        )
    }
}


