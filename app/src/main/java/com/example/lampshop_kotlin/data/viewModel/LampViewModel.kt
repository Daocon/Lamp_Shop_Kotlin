package com.example.lampshop_kotlin.data.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lampshop_kotlin.data.model.Lamp
import com.example.lampshop_kotlin.data.network.ApiService
import kotlinx.coroutines.launch

class LampViewModel : ViewModel() {
    var lampListResponse : List<Lamp> by mutableStateOf(listOf())
    var errorMessase: String by mutableStateOf("")

    fun getLampList(){
        viewModelScope.launch {
            var apiService = ApiService.getInstance()
            try {
                var lampList = apiService.getAllLamps()
                lampListResponse = lampList
            }catch (e:Exception){
                errorMessase = e.message.toString()
            }
        }
    }
}