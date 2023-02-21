package com.example.sendfund.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.sendfund.common.NetworkResult
import com.example.sendfund.common.Repository
import com.example.sendfund.model.LoginResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {


    private var _password = ""
    val password: String
        get() = _password

    private var _username = ""
    val username: String
        get() = _username


    private val _response:
            MutableLiveData<NetworkResult<LoginResponseModel>> = MutableLiveData()

    val response: LiveData<NetworkResult<LoginResponseModel>> = _response


    override fun onCleared() {
        super.onCleared()
    }

    fun reinitializeData() {

        _password = ""
        _username = ""

    }

    fun isPasswordLengthFour(otp: String?): Boolean {
        return (otp?.length ?: 0) == 4
    }

    fun isUserNameNotEmpty(name: String?): Boolean {
        return (name?.length ?: 0) > 1
    }

    fun loginResponse() = viewModelScope.launch {
        repository.login().collect { values ->
            _response.value = values
        }
    }
}