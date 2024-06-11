package com.example.lampshop_kotlin.ui.screens.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lampshop_kotlin.data.network.LampService
import com.example.lampshop_kotlin.data.network.request.LoginRequest
import com.example.lampshop_kotlin.data.network.response.LoginResponse
import com.example.lampshop_kotlin.domain.repository.LampRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val lampRepository: LampRepository
) : ViewModel() {

    private val _canNavigate = Channel<Boolean> {  }
    val canNavigate = _canNavigate.receiveAsFlow()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val response = lampRepository.login(username, password)
            if (response.isSuccessful) {
                _canNavigate.send(true)
            } else {
                _canNavigate.send(false)
            }
        }
    }
}