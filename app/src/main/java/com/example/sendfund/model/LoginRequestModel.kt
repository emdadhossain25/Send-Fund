package com.example.sendfund.model

import com.google.gson.annotations.SerializedName

data class LoginRequestModel(
    @SerializedName("pin")
    val pin: String,
    @SerializedName("user")
    val user: String
)