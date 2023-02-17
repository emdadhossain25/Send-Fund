package com.example.sendfund.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val accountInfo: AccountInfo,
    val userInfo: UserInfo
) : Parcelable