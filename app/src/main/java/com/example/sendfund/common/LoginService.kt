package com.example.sendfund.common

import com.example.sendfund.model.LoginRequestModel
import com.example.sendfund.model.LoginResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {
    @Headers("Content-Type: application/json")
    @POST(Constants.LOGIN_URL)
    suspend fun loginUser(@Body loginRequestModel: LoginRequestModel): Response<LoginResponseModel>
}