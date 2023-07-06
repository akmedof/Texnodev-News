package com.aslangroup.texnodev.presentaion.component

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.aslangroup.texnodev.R
import com.aslangroup.texnodev.app.theme.BackgroundComponent
import com.aslangroup.texnodev.app.theme.BlueMain
import com.aslangroup.texnodev.app.theme.PADDING_DEFAULT
import com.aslangroup.texnodev.app.theme.PADDING_MEDIUM
import com.aslangroup.texnodev.app.theme.PADDING_SMALL
import com.aslangroup.texnodev.app.theme.PasswordIconColor
import com.aslangroup.texnodev.app.theme.RADIUS_SMALE
import com.aslangroup.texnodev.app.theme.TEXT_MEDIUM
import com.aslangroup.texnodev.app.theme.TextColor
import com.aslangroup.texnodev.app.theme.TextEmptyColor

@Composable
fun EditTextApp(
    label: String,
    value: String,
    fontSize: TextUnit = TEXT_MEDIUM,
    maxLength: Int = 50,
    keyboardType: KeyboardType = KeyboardType.Text,
    onTextChange: (String) -> Unit,
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier
) {
    val visibilityPasswordIcon = remember { mutableStateOf(false) }
    if (keyboardType != KeyboardType.Password) visibilityPasswordIcon.value = true
    val icon = if (visibilityPasswordIcon.value) R.drawable.password_visiblity
    else R.drawable.password_in_visibility

    BasicTextField(
        value = value,
        onValueChange = { if (it.length <= maxLength) onTextChange(it) },
        singleLine = true,
        maxLines = 1,
        textStyle = TextStyle(fontSize = fontSize, color = MaterialTheme.colors.TextColor),
        cursorBrush = SolidColor(BlueMain),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = keyboardType
        ),
        visualTransformation = if (visibilityPasswordIcon.value)
            VisualTransformation.None else PasswordVisualTransformation(),
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .padding(top = PADDING_MEDIUM)
                    .fillMaxWidth()
                    .height(55.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.TextColor.copy(0.1f),
                        shape = RoundedCornerShape(RADIUS_SMALE)
                    )
                    .clip(shape = RoundedCornerShape(RADIUS_SMALE))
                    .background(MaterialTheme.colors.BackgroundComponent)
                    .padding(vertical = PADDING_SMALL, horizontal = PADDING_DEFAULT)
                    .padding(PaddingValues(vertical = PADDING_SMALL))
            ){
                Box {
                    innerTextField()
                    if (value.isEmpty()) {
                        Text(
                            text = label,
                            fontSize = fontSize,
                            fontWeight = FontWeight.W300,
                            color = MaterialTheme.colors.TextEmptyColor,
                        )
                    }
                }
                AnimatedVisibility(visible = (keyboardType == KeyboardType.Password)) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = "",
                        tint = MaterialTheme.colors.PasswordIconColor,
                        modifier = modifier
                            .size(25.dp)
                            .clip(RoundedCornerShape(50))
                            .clickable(onClick = {
                                visibilityPasswordIcon.value = !visibilityPasswordIcon.value
                            })
                    )
                }
            }
        }
    )
}