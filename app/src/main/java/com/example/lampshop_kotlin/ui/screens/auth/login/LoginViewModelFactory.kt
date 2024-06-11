package com.example.lampshop_kotlin.ui.screens.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lampshop_kotlin.data.network.LampService

class LoginViewModelFactory(private val lampService: LampService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(lampService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}