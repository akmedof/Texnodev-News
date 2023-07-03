package com.aslangroup.texnodev.app.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val LightGray = Color(0xFFF8F8F8)
val DarkGray = Color(0xFF181B29)
val White = Color(0xFFFFFFFF)
val Dark = Color(0xFF2C2C2C)
val ReedMain = Color(0xFFF80357)
val BlueMain = Color(0xFF0777FF)
val AuthorBoxTransparent = Color(0xBF060A20)
val Transparent = Color(0x60A20)

val Colors.Background
    @Composable
    get() = if (isSystemInDarkTheme())  DarkGray else LightGray

val Colors.BackgroundComponent
    @Composable
    get() = if (isSystemInDarkTheme()) Dark else White

