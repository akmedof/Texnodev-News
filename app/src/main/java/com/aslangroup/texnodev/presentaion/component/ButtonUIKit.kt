package com.aslangroup.texnodev.presentaion.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aslangroup.texnodev.R
import com.aslangroup.texnodev.app.theme.BackgroundComponent
import com.aslangroup.texnodev.app.theme.Blue
import com.aslangroup.texnodev.app.theme.PADDING_MEDIUM
import com.aslangroup.texnodev.app.theme.PADDING_SMALL
import com.aslangroup.texnodev.app.theme.RADIUS_SMALE
import com.aslangroup.texnodev.app.theme.TEXT_MEDIUM
import com.aslangroup.texnodev.app.theme.TextColor
import com.aslangroup.texnodev.app.theme.White

@Composable
fun ButtonDefault(
    label: String = "Button",
    onClick: () -> Unit,
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(top = PADDING_MEDIUM)
            .fillMaxWidth()
            .height(55.dp)
            .clip(shape = RoundedCornerShape(RADIUS_SMALE))
            .background(Blue)
            .clickable(onClick = onClick)
    ) {
        Text(
            text = label,
            color = White,
            fontSize = TEXT_MEDIUM,
            fontWeight = FontWeight.W400,
            modifier = modifier.align(
                Alignment.Center
            )
        )
    }
}

@Composable
fun ButtonSocial(
    label: String = "Google",
    icon: Int =  R.drawable.google_icon,
    onClick: () -> Unit,
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(top = PADDING_MEDIUM)
            .fillMaxWidth()
            .height(55.dp)
            .clip(shape = RoundedCornerShape(RADIUS_SMALE))
            .background(MaterialTheme.colors.BackgroundComponent)
            .clickable { }
    ) {
        Image(painter = painterResource(id = icon), contentDescription = "", modifier.size(25.dp))
        Spacer(modifier = modifier.padding(PADDING_SMALL))
        Text(
            text = label,
            color = MaterialTheme.colors.TextColor,
            fontSize = TEXT_MEDIUM,
            fontWeight = FontWeight.W400,
            modifier = modifier
        )
    }
}

@Composable
fun AuthORLine(
    label: String,
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(PADDING_SMALL),
        modifier = modifier
            .fillMaxWidth()
            .padding(PADDING_MEDIUM)
    ) {
        Divider(
            modifier
                .fillMaxWidth(0.435f)
                .height(1.dp)
                .background(MaterialTheme.colors.TextColor))
        Text(
            text = label,
            color = MaterialTheme.colors.TextColor,
            fontSize = TEXT_MEDIUM,
            fontWeight = FontWeight.W400,
//            modifier = modifier.fillMaxWidth(0.2f)
        )
        Divider(
            modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(MaterialTheme.colors.TextColor))
    }
}

@Composable
fun AuthNavText(
    label: String,
    buttonText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(top = PADDING_MEDIUM)
            .fillMaxWidth()
    ) {

//        Text(
//            text = buildAnnotatedString {
//                withStyle(style = SpanStyle(color = MaterialTheme.colors.TextColor)) {
//                    append(label)
//                }
//
//                withStyle(style = SpanStyle(color = Blue,textDecoration = TextDecoration.Underline)) {
//                    TextButton(onClick = { /*TODO*/ }) {
//                        append(buttonText)
//                    }
//                }
//            },
//            color = MaterialTheme.colors.TextColor,
//            fontSize = TEXT_MEDIUM,
//            fontWeight = FontWeight.W400,
//        )

        Text(
            text = label,
            color = MaterialTheme.colors.TextColor,
            fontSize = TEXT_MEDIUM,
            fontWeight = FontWeight.W400,
//            modifier = modifier.padding(end = PADDING_SMALL)
        )
        TextButton(onClick = onClick ) {
            Text(
                text = buttonText,
                color = Blue,
                fontSize = TEXT_MEDIUM,
                fontWeight = FontWeight.W400,
            )
        }
    }
}

@Composable
fun AuthForgetPassword(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append(label)
                    }
                },
                color = MaterialTheme.colors.TextColor,
                fontSize = TEXT_MEDIUM,
                fontWeight = FontWeight.W400,
            )
        }
    }
}
