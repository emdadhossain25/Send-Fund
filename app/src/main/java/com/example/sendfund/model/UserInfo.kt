package com.example.sendfund.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfo(
    val Email: String,
    val Id: Int,
    val ProfileImage: String,
    val UserName: String,
    val WalletAddress: String,
    val smartContactWallet: String
) : Parcelable