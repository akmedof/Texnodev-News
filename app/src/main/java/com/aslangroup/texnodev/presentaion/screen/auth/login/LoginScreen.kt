package com.aslangroup.texnodev.presentaion.screen.auth.login

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
import com.aslangroup.texnodev.presentaion.component.AuthForgetPassword
import com.aslangroup.texnodev.presentaion.component.AuthNavText
import com.aslangroup.texnodev.presentaion.component.AuthORLine
import com.aslangroup.texnodev.presentaion.component.ButtonDefault
import com.aslangroup.texnodev.presentaion.component.ButtonSocial
import com.aslangroup.texnodev.presentaion.navigations.Graph
import com.aslangroup.texnodev.presentaion.navigations.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel(),
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier
) {

    val email by viewModel.email
    val password by viewModel.password

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
                        text = "Texnodevə daxil olun!",
                        color = MaterialTheme.colors.TextColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = TEXT_LARGE * 2.5,
                        lineHeight = 50.sp
                    )
                    Text(
                        text = "Aşağıdakı xanaları dolduraraq aplikasiyaya keçid edin.",
                        color = MaterialTheme.colors.TextColor,
                        fontWeight = FontWeight.W400,
                        fontSize = TEXT_MEDIUM
                    )
                    Spacer(modifier = modifier.padding(PADDING_DEFAULT))
                    EditTextApp(
                        label = "E-Mail",
                        value = email,
                        keyboardType = KeyboardType.Email,
                        onTextChange = { viewModel.updateEmail(it) }
                    )
                    EditTextApp(
                        label = "Password",
                        value = password,
                        keyboardType = KeyboardType.Password,
                        onTextChange = { viewModel.updatePassword(it) }
                    )
                    Spacer(modifier = modifier.padding(PADDING_MEDIUM))
                    ButtonDefault(
                        label = "Daxil ol",
                        onClick = {
                            navController.popBackStack()
                            navController.navigate(Graph.MAIN)
                        }
                    )
                    Spacer(modifier = modifier.padding(PADDING_SMALL))
                    AuthORLine(label = "Və ya")
                    ButtonSocial(
                        label = "Google ilə daxil olun",
                        onClick = {

                        }
                    )
                    Spacer(modifier = modifier.padding(PADDING_SMALL))
                    AuthNavText(
                        label = "Hesabınız yoxdur?",
                        buttonText = "Qeydiyyatdan keç",
                        onClick = {
                            navController.popBackStack()
                            navController.navigate(Screen.Register.route)
                        }
                    )
                    Spacer(modifier = modifier.padding(PADDING_SMALL))
                    AuthForgetPassword(
                        label = "Şifrənizi unuttunuz?",
                        onClick = {}
                    )
                }
            }
        }
    )
}