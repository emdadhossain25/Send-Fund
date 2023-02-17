package com.example.sendfund.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginResponseModel(
    @SerializedName("data")
    val dataFromResponse: Data?,
    @SerializedName("error")
    val error: String?,
    @SerializedName("messages")
    val messages: List<String>?,
    @SerializedName("path")
    val path: String?,
    @SerializedName("requestId")
    val requestId: String?,
    @SerializedName("status")
    val status: Boolean = false,
    @SerializedName("statusCode")
    val statusCode: Int?,
    @SerializedName("timeStamp")
    val timestamp: String?
) : Parcelable