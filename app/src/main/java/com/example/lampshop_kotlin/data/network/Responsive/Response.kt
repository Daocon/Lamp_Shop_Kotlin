package com.example.lampshop_kotlin.data.network.Responsive

import com.example.lampshop_kotlin.data.network.LampResponse

data class Response(
    val status: Int,
    val message: String,
    val data: List<LampResponse>
)
