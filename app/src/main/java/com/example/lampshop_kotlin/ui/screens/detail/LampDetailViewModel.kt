package com.example.lampshop_kotlin.ui.screens.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lampshop_kotlin.data.network.LampResponse
import com.example.lampshop_kotlin.data.network.LampService
import com.example.lampshop_kotlin.domain.model.lamp.Lamp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

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
@HiltViewModel
class LampDetailViewModel @Inject constructor(
    private val lampService: LampService
): ViewModel() {

    private val _lamp = MutableLiveData<Lamp?>()
    val lamp: MutableLiveData<Lamp?> = _lamp

    fun getLampByID(id: String) {
        viewModelScope.launch {
            try {
                val response = lampService.getLampById(id)
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