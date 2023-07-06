package com.aslangroup.texnodev.presentaion.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aslangroup.texnodev.app.theme.BackgroundComponent
import com.aslangroup.texnodev.app.theme.IconColor
import com.aslangroup.texnodev.app.theme.PADDING_DEFAULT
import com.aslangroup.texnodev.app.theme.PADDING_LARGE
import com.aslangroup.texnodev.app.theme.PADDING_MEDIUM
import com.aslangroup.texnodev.app.theme.PADDING_SMALL
import com.aslangroup.texnodev.app.theme.RADIUS_CYCLE
import com.aslangroup.texnodev.app.theme.RADIUS_MEDIUM
import com.aslangroup.texnodev.app.theme.TEXT_EXTRA
import com.aslangroup.texnodev.app.theme.TEXT_LARGE
import com.aslangroup.texnodev.app.theme.TEXT_MEDIUM
import com.aslangroup.texnodev.app.theme.TextColor
import com.aslangroup.texnodev.app.theme.TextEmptyColor

@ExperimentalMaterialApi
@Composable
fun LogoutBottomSheet(
    sheetState: ModalBottomSheetState,
    modifier: Modifier = Modifier,
    onClickLogout: () -> Unit,
    onClickCancel: () -> Unit,
){
    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetElevation = 10.dp,
        sheetShape = RoundedCornerShape(
            topStart = RADIUS_MEDIUM,
            topEnd = RADIUS_MEDIUM
        ),
        sheetContent = {
            LogoutContent(
                onClickLogout = onClickLogout,
                onClickCancel = onClickCancel,
            )
        },
        modifier = modifier
//            .fillMaxHeight(0.75f)
            .clip(
                RoundedCornerShape(
                    topStart = RADIUS_MEDIUM,
                    topEnd = RADIUS_MEDIUM
                ),
            )
    ){}
}

@Composable
private fun LogoutContent(
    onClickLogout: () -> Unit,
    onClickCancel: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.BackgroundComponent)
            .padding(horizontal = PADDING_DEFAULT).padding(bottom = PADDING_MEDIUM)
    ) {
//        item {
            Box(
                modifier = modifier
                    .padding(PADDING_SMALL)
                    .width(100.dp)
                    .height(5.dp)
                    .clip(RoundedCornerShape(RADIUS_CYCLE))
                    .background(MaterialTheme.colors.IconColor.copy(0.25f))
            )
            Spacer(modifier = modifier.padding(PADDING_DEFAULT))
            Text(
                text = "Log out of Texnodev?",
                color = MaterialTheme.colors.TextColor,
                fontSize = TEXT_EXTRA,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = modifier.padding(PADDING_DEFAULT))
            Text(
                text = "You can always log back in at any time. If you just want to switch accounts, you can do that by adding an existing account.",
                color = MaterialTheme.colors.TextEmptyColor,
                fontSize = TEXT_MEDIUM,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                modifier = modifier.padding(horizontal = PADDING_LARGE)
            )
            ButtonDefault(
                label = "Log out",
                onClick = onClickLogout
            )
            ButtonDefaultLine(
                label = "Cancel",
                onClick = onClickCancel
            )
//        }
    }
}