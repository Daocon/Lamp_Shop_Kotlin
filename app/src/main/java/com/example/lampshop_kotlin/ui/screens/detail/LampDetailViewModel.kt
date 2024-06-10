package com.example.lampshop_kotlin.ui.screens.detail

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lampshop_kotlin.data.network.ApiService
import com.example.lampshop_kotlin.data.network.LampResponse
import com.example.lampshop_kotlin.domain.model.Lamp.Lamp
import kotlinx.coroutines.launch

fun LampResponse.toLamp(): Lamp {
    return Lamp(
        id = id,
        name = name,
        image = image,
        id_category = id_category,
        price = price,
        rate = rate,
        description = description
    )
}
class LampDetailViewModel : ViewModel() {

    private val _lamp = MutableLiveData<Lamp?>()
    val lamp: MutableLiveData<Lamp?> = _lamp

    fun getLampByID(id: String) {
        viewModelScope.launch {
            try {
                val response = ApiService().lampService.getLampById(id)
                if (response.isSuccessful) {
                    _lamp.value = response.body()?.data?.toLamp()
                } else {
                    _lamp.value = null
                }
            } catch (e: Exception) {
                Log.e("TAG", "getLamp: " + e.message)
                _lamp.value = null
            }
        }
    }

}