package com.example.sendfund.common

import com.example.sendfund.model.LoginRequestModel
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val loginService: LoginService) {
    suspend fun loginPost() = loginService
        .loginUser(
            LoginRequestModel(
                "1234",
                "nadimh"
            )
        )
}
