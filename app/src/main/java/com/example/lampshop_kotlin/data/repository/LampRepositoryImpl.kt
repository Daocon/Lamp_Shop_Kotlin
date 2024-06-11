package com.example.lampshop_kotlin.data.repository

import com.example.lampshop_kotlin.data.network.LampService
import com.example.lampshop_kotlin.data.network.request.LoginRequest
import com.example.lampshop_kotlin.data.network.response.LampResponsive
import com.example.lampshop_kotlin.data.network.response.LoginResponse
import com.example.lampshop_kotlin.data.network.response.Response
import com.example.lampshop_kotlin.domain.repository.LampRepository
import javax.inject.Inject

class LampRepositoryImpl @Inject constructor(
    private val apiService: LampService
) : LampRepository {
    override suspend fun getAllLamps(): retrofit2.Response<Response> {
        return apiService.getAllLamps()
    }

    override suspend fun getLampById(id: String): retrofit2.Response<LampResponsive> {
        return apiService.getLampById(id)
    }

    override suspend fun login(email: String, password: String): retrofit2.Response<LoginResponse> {
        val loginRequest = LoginRequest(email, password)
        return apiService.login(loginRequest)
    }
}