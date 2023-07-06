package com.aslangroup.texnodev.presentaion.screen.auth.register

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.aslangroup.texnodev.app.theme.Background
import com.aslangroup.texnodev.app.theme.PADDING_DEFAULT
import com.aslangroup.texnodev.app.theme.PADDING_MEDIUM
import com.aslangroup.texnodev.app.theme.PADDING_SMALL
import com.aslangroup.texnodev.app.theme.TEXT_LARGE
import com.aslangroup.texnodev.app.theme.TEXT_MEDIUM
import com.aslangroup.texnodev.app.theme.TextColor
import com.aslangroup.texnodev.presentaion.component.AppBarAuth
import com.aslangroup.texnodev.presentaion.component.EditTextApp
import com.aslangroup.texnodev.presentaion.component.AuthNavText
import com.aslangroup.texnodev.presentaion.component.AuthORLine
import com.aslangroup.texnodev.presentaion.component.ButtonDefault
import com.aslangroup.texnodev.presentaion.component.ButtonSocial
import com.aslangroup.texnodev.presentaion.navigations.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavHostController,
    viewModel: RegisterViewModel = hiltViewModel(),
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier
) {

    val name by viewModel.name
    val surname by viewModel.surname
    val email by viewModel.email
    val password by viewModel.password
    val againPassword by viewModel.againPassword

    Scaffold(
        containerColor = MaterialTheme.colors.Background,
        topBar = { AppBarAuth() },
        content = {
            LazyColumn(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(top = 70.dp)
                    .fillMaxSize()
                    .padding(horizontal = PADDING_MEDIUM)
            ) {
                item {
                    Text(
                        text = "Texnodevə xoş gəldiniz!",
                        color = MaterialTheme.colors.TextColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = TEXT_LARGE * 2.5,
                        lineHeight = 50.sp
                    )
                    Text(
                        text = "Aplikasiyaya davam etmək üçün qeydiyyatdan keçməlisiniz.",
                        color = MaterialTheme.colors.TextColor,
                        fontWeight = FontWeight.W400,
                        fontSize = TEXT_MEDIUM
                    )
                    EditTextApp(
                        label = "Ad",
                        value = name,
                        keyboardType = KeyboardType.Email,
                        onTextChange = { viewModel.updateName(it) }
                    )
                    EditTextApp(
                        label = "Soyad",
                        value = surname,
                        keyboardType = KeyboardType.Email,
                        onTextChange = { viewModel.updateSurname(it) }
                    )
                    EditTextApp(
                        label = "E-poçt ünvanı",
                        value = email,
                        keyboardType = KeyboardType.Email,
                        onTextChange = { viewModel.updateEmail(it) }
                    )
                    EditTextApp(
                        label = "Şifrə",
                        value = password,
                        keyboardType = KeyboardType.Password,
                        onTextChange = { viewModel.updatePassword(it) }
                    )
                    EditTextApp(
                        label = "Şifrə (Təkrar)",
                        value = againPassword,
                        keyboardType = KeyboardType.Password,
                        onTextChange = { viewModel.updateAgainPassword(it) }
                    )
                    Spacer(modifier = modifier.padding(PADDING_MEDIUM))
                    ButtonDefault(
                        label = "Qeydiyyatdan keç",
                        onClick = {

                        }
                    )
                    Spacer(modifier = modifier.padding(PADDING_SMALL))
                    AuthORLine(label = "Və ya")
                    ButtonSocial(
                        label = "Google ilə qeydiyyatdan keçin",
                        onClick = {

                        }
                    )
                    Spacer(modifier = modifier.padding(PADDING_SMALL))
                    AuthNavText(
                        label = "Hesabın var?",
                        buttonText = "Daxil ol",
                        onClick = {
                            navController.popBackStack()
                            navController.navigate(Screen.Login.route)
                        }
                    )
//                    Spacer(modifier = modifier.padding(PADDING_SMALL))
//                    AuthForgetPassword(
//                        label = "Şifrənizi unuttunuz?",
//                        onClick = {}
//                    )
                }
            }
        }
    )
}