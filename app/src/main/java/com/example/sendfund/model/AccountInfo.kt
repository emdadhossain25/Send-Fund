package com.example.sendfund.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AccountInfo(
    val balance: Double,
    val currency: String
) : Parcelable