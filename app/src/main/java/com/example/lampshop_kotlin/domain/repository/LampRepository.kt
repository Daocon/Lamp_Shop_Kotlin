package com.example.lampshop_kotlin.domain.repository

import com.example.lampshop_kotlin.data.network.response.LoginResponse
import retrofit2.Response
import com.example.lampshop_kotlin.data.network.response.LampResponsive as ItemDetail
import com.example.lampshop_kotlin.data.network.response.Response as Item

interface LampRepository {
    suspend fun getAllLamps(): Response<Item>
    suspend fun getLampById(id: String): Response<ItemDetail>
    suspend fun login(email: String, password: String): Response<LoginResponse>
}