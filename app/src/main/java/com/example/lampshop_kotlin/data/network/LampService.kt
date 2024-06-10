package com.example.lampshop_kotlin.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.lampshop_kotlin.data.network.Responsive.Response as Item
import com.example.lampshop_kotlin.data.network.Responsive.LampResponsive as ItemDetail

interface LampService {
    @GET("lampRouter/getListLamp")
    suspend fun getAllLamps(): Response<Item>
    //getLampById
    @GET("lampRouter/getLamp/{id}")
    suspend fun getLampById(@Path("id") id: String): Response<ItemDetail>
}