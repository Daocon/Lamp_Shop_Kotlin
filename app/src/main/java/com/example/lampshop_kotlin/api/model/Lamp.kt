package com.example.lampshop_kotlin.api.model

import com.google.gson.annotations.SerializedName

data class Lamp(
    val id : String,
    val name : String,
    val image : String,
    val id_category : String,
    val price : String,
    val rate : String,
    val description : String
)
