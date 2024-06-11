package com.example.lampshop_kotlin.data.network

import com.example.lampshop_kotlin.data.network.request.LoginRequest
import com.example.lampshop_kotlin.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import com.example.lampshop_kotlin.data.network.response.Response as Item
import com.example.lampshop_kotlin.data.network.response.LampResponsive as ItemDetail

interface LampService {
    @GET("lampRouter/getListLamp")
    suspend fun getAllLamps(): Response<Item>
    //getLampById
    @GET("lampRouter/getLamp/{id}")
    suspend fun getLampById(@Path("id") id: String): Response<ItemDetail>

    @POST("userRouter/signin")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}