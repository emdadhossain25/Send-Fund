package com.example.sendfund.common

import com.example.sendfund.model.LoginResponseModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse() {
    suspend fun login(username: String, password: String): Flow<NetworkResult<LoginResponseModel>> {

        return flow {
            emit(safeApiCall {
                remoteDataSource.loginPost(username,password)
            })
        }.flowOn(Dispatchers.IO)
    }

}