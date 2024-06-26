package com.example.lampshop_kotlin.ui.screens.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lampshop_kotlin.domain.model.lamp.Lamp
import com.example.lampshop_kotlin.data.network.LampResponse
import com.example.lampshop_kotlin.data.network.LampService
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
class LampViewModel @Inject constructor(
    private val lampService: LampService
): ViewModel() {
    private val _lamps = MutableLiveData<List<Lamp>>()
    val lamps: LiveData<List<Lamp>> = _lamps

    init {
        getLamps()
    }

    fun getLamps() {
        viewModelScope.launch {
            try {
                val response = lampService.getAllLamps()
                if (response.isSuccessful) {
                    _lamps.value = response.body()?.data?.map { it.toLamp() } ?: emptyList()
                } else {
                    _lamps.value = emptyList()
                }
            } catch (e: Exception) {
                Log.e("TAG", "getLamps: " + e.message)
                _lamps.value = emptyList()
            }
        }
    }
}