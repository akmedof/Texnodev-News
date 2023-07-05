package com.aslangroup.texnodev.presentaion.screen.auth.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _email = mutableStateOf("")
    val email get() = _email

    private val _password = mutableStateOf("")
    val password get() = _password

    fun updateEmail(value: String){
        _email.value = value
    }

    fun updatePassword(value: String){
        _password.value = value
    }

}