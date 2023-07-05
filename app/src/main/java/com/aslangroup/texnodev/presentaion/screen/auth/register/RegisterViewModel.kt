package com.aslangroup.texnodev.presentaion.screen.auth.register

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    private val _name = mutableStateOf("")
    val name get() = _name

    private val _surname = mutableStateOf("")
    val surname get() = _surname

    private val _email = mutableStateOf("")
    val email get() = _email

    private val _password = mutableStateOf("")
    val password get() = _password

    private val _againPassword = mutableStateOf("")
    val againPassword get() = _againPassword

    fun updateName(value: String){
        _name.value = value
    }

    fun updateSurname(value: String){
        _surname.value = value
    }

    fun updateEmail(value: String){
        _email.value = value
    }

    fun updatePassword(value: String){
        _password.value = value
    }

    fun updateAgainPassword(value: String){
        _againPassword.value = value
    }

}