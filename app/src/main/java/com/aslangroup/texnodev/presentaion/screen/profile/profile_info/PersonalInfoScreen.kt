package com.aslangroup.texnodev.presentaion.screen.profile.profile_info

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.aslangroup.texnodev.R
import com.aslangroup.texnodev.app.theme.Background
import com.aslangroup.texnodev.app.theme.BackgroundComponent
import com.aslangroup.texnodev.app.theme.BlueMain
import com.aslangroup.texnodev.app.theme.PADDING_DEFAULT
import com.aslangroup.texnodev.app.theme.PADDING_LARGE
import com.aslangroup.texnodev.app.theme.PADDING_MEDIUM
import com.aslangroup.texnodev.app.theme.PADDING_SMALL
import com.aslangroup.texnodev.app.theme.RADIUS_CYCLE
import com.aslangroup.texnodev.app.theme.RADIUS_SMALE
import com.aslangroup.texnodev.app.theme.TEXT_MEDIUM
import com.aslangroup.texnodev.app.theme.TEXT_SMALE
import com.aslangroup.texnodev.app.theme.TextColor
import com.aslangroup.texnodev.app.theme.White
import com.aslangroup.texnodev.domain.model.user.PersonalData
import com.aslangroup.texnodev.presentaion.component.AppBarDefault
import com.aslangroup.texnodev.presentaion.component.ButtonDefault
import com.aslangroup.texnodev.presentaion.component.EditTextApp
import com.aslangroup.texnodev.presentaion.component.LogoutBottomSheet
import com.aslangroup.texnodev.presentaion.navigations.Graph
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun PersonalInfoScreen(
    navController: NavHostController,
    viewModel: PersonalInfoViewModel = hiltViewModel(),
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }

    viewModel.data.value?.let { item ->
        name = item.name
        surname = item.surname
        email = item.email
        city = item.city
    }

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = false
    )
    val scope = rememberCoroutineScope()

    Box {
        Scaffold(
            topBar = {
                AppBarDefault(
                    label = "Personal Info",
                    onBackClick = { navController.popBackStack() })
            },
            bottomBar = {
                ButtonDefault(
                    label = "Qeydiyyatdan keç",
                    modifier = modifier
                        .padding(bottom = PADDING_DEFAULT)
                        .padding(horizontal = PADDING_DEFAULT),
                    onClick = {
                        viewModel.updatePersonalData(
                            PersonalData(
                                name = name,
                                surname = surname,
                                email = email,
                                city = city,
                            )
                        )
                        Log.d("aslan-> PersonalData: ", viewModel.data.value.toString())
                    }
                )
            },
            contentColor = MaterialTheme.colors.Background
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .padding(top = 80.dp)
                    .fillMaxSize()
                    .padding(horizontal = PADDING_DEFAULT)
            ) {
                item {
                    ProfileAvatarEdit()
                    Spacer(modifier = modifier.padding(top = PADDING_LARGE))
                    EditTextApp(
                        label = "Ad",
                        value = name,
                        keyboardType = KeyboardType.Text,
                        onTextChange = { name = it }
                    )
                    EditTextApp(
                        label = "Soyad",
                        value = surname,
                        keyboardType = KeyboardType.Text,
                        onTextChange = { surname = it }
                    )
                    EditTextApp(
                        label = "E-Mail",
                        value = email,
                        keyboardType = KeyboardType.Email,
                        onTextChange = { email = it }
                    )
                    EditTextApp(
                        label = "Şəhər",
                        value = city,
                        keyboardType = KeyboardType.Text,
                        onTextChange = { city = it }
                    )
                    GenderCheck()
                    MultiSelectCategory(onClick = {
                        scope.launch {
                            sheetState.show()
                        }
                    })
                }
            }
        }
        // Bottom Sheet UI
    }
}

@Composable
private fun ProfileAvatarEdit(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.test_avatar),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(175.dp)
                .clip(shape = RoundedCornerShape(RADIUS_CYCLE))
        )
        Box(
            modifier = modifier
                .border(
                    width = 1.dp,
                    color = BlueMain,
                    shape = RoundedCornerShape(RADIUS_CYCLE)
                )
                .clip(shape = RoundedCornerShape(RADIUS_CYCLE))
                .background(MaterialTheme.colors.Background)
                .clickable(onClick = {})
                .align(Alignment.BottomEnd)
                .padding(
                    PaddingValues(
                        horizontal = PADDING_MEDIUM,
                        vertical = PADDING_SMALL
                    )
                )
        ) {
            Text(
                text = "Edit",
                fontSize = TEXT_MEDIUM,
                fontWeight = FontWeight.W400,
                color = MaterialTheme.colors.TextColor,
                modifier = modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
private fun GenderCheck(
    modifier: Modifier = Modifier
) {
    var gender by remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(top = PADDING_MEDIUM)
            .fillMaxWidth()
            .height(56.dp)
            .clip(shape = RoundedCornerShape(RADIUS_SMALE))
            .background(MaterialTheme.colors.BackgroundComponent)
    ) {
        GenderCheckItem(
            label = "Qadin",
            select = gender,
            modifier = modifier.weight(0.5f),
            onClick = {
                gender = it
            }
        )
        GenderCheckItem(
            label = "Kisi",
            select = gender,
            modifier = modifier.weight(0.5f),
            onClick = {
                gender = it
            }
        )
    }
}

@Composable
private fun GenderCheckItem(
    label: String,
    select: String,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    val isCheck = label == select
    val background = if (isCheck) BlueMain else MaterialTheme.colors.Background
    val content = if (isCheck) White else MaterialTheme.colors.TextColor
    Box(
        modifier = modifier
            .padding(PADDING_SMALL)
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(RADIUS_SMALE))
            .background(background)
            .clickable(onClick = { onClick(label) })
    ) {
        Text(
            text = label,
            color = content,
            fontSize = TEXT_MEDIUM,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@ExperimentalMaterialApi
@Composable
private fun MultiSelectCategory(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .padding(top = PADDING_MEDIUM)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(RADIUS_SMALE))
            .background(MaterialTheme.colors.BackgroundComponent)
            .padding(PaddingValues(PADDING_MEDIUM))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = "Categories of your choice",
                color = MaterialTheme.colors.TextColor,
                fontSize = TEXT_MEDIUM,
                fontWeight = FontWeight.SemiBold,
            )
            Box(
                modifier = modifier
                    .border(
                        width = 1.dp,
                        color = BlueMain,
                        shape = RoundedCornerShape(RADIUS_CYCLE)
                    )
                    .clickable(onClick = onClick)
                    .padding(horizontal = PADDING_MEDIUM, vertical = PADDING_SMALL)
            ) {
                Text(
                    text = "Edit",
                    color = MaterialTheme.colors.TextColor,
                    fontSize = TEXT_MEDIUM,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }

    }
}