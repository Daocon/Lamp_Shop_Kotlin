package com.example.lampshop_kotlin.data.network

import com.google.gson.annotations.SerializedName

data class LampResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("id_category") val id_category: String,
    @SerializedName("price") val price: String,
    @SerializedName("rate") val rate: String,
    @SerializedName("description") val description: String,
)