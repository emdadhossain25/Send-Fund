package com.example.sendfund.common

import com.example.sendfund.model.LoginRequestModel
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val loginService: LoginService) {
    suspend fun loginPost(username: String, password: String) = loginService
        .loginUser(
            LoginRequestModel(
                password,
                username
            )
        )
}
