package com.example.lampshop_kotlin.data.network.response

import com.example.lampshop_kotlin.domain.model.user.User

data class LoginResponse(
    val status: Int,
    val message: String,
    val data: User,
    val token: String,
    val refreshToken: String
)
