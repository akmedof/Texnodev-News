package com.aslangroup.texnodev.presentaion.component

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
            .padding(horizontal = PADDING_DEFAULT).padding(top = PADDING_SMALL)
            .fillMaxWidth()
            .height(56.dp)
            .clip(shape = RoundedCornerShape(RADIUS_SMALE/2))
            .background(MaterialTheme.colors.BackgroundComponent)
            .padding(PaddingValues(horizontal = PADDING_DEFAULT))
    ) {
        Image(painter = painterResource(id = logo), contentDescription = "", modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(PADDING_DEFAULT),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AppActionIcon(icon = R.drawable.search_icon, color = BlueMain)
            AppActionIcon(icon = R.drawable.notification_icon, color = BlueMain)
        }
    }
}

@Composable
fun AppActionIcon(icon: Int, color: Color, modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .clip(shape = RoundedCornerShape(RADIUS_CYCLE))
        .clickable { }
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "",
            tint = color,
            modifier = modifier.padding(PaddingValues(PADDING_SMALL)).size(20.dp)
        )
    }
}
