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
    private val _response:
            MutableLiveData<NetworkResult<LoginResponseModel>> = MutableLiveData()

    val response: LiveData<NetworkResult<LoginResponseModel>> = _response

    private val _userName: MutableLiveData<String> = MutableLiveData()
    val userName: LiveData<String>
        get() = _userName


    private val _password: MutableLiveData<String> = MutableLiveData()
    val password: LiveData<String>
        get() = _password


    init {
        getUserName("")
        getPassWord("")
    }

    fun getUserName(name: String): Boolean {
        _userName.value = name
        return userName.value.isNullOrEmpty()
    }

    fun getPassWord(password: String): Boolean {
        _password.value = password
        return password.length == 4
    }

    fun loginResponse() = viewModelScope.launch {
        repository.login().collect { values ->
            _response.value = values
        }
    }
}