package com.example.lampshop_kotlin.ui.screens.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lampshop_kotlin.data.network.ApiService
import com.example.lampshop_kotlin.data.network.LampService
import com.example.lampshop_kotlin.data.network.request.LoginRequest
import com.example.lampshop_kotlin.data.network.response.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel(private val lampService: LampService) : ViewModel() {
    private val _loginResult = MutableLiveData<Result<LoginResponse>>()
    val loginResult: LiveData<Result<LoginResponse>> = _loginResult

    fun login(username: String, password: String, onLoginSuccess: () -> Unit) {
        viewModelScope.launch {
            val response = try {
                val result = lampService.login(LoginRequest(username, password))
                if (result.isSuccessful && result.body()?.status == 200) {
                    onLoginSuccess()
                    Result.success(result.body()!!)
                } else {
                    Result.failure(RuntimeException("Failed to login"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
            _loginResult.value = response
        }
    }
}