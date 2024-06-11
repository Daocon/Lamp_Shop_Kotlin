package com.example.lampshop_kotlin.domain.model.user

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("_id")
    val id: String,
    val email: String,
    val avatar: String,
    val name: String,
    val password: String,
    val phone: String
)