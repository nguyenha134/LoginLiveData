package com.example.loginlivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var isSuccess: MutableLiveData<Boolean> = MutableLiveData()

    fun clickLogin(username1: String, password1: String) =
        if (username1 == USERNAME && password1 == PASSWORD) {
            isSuccess.value = true
        } else {
            isSuccess.value = false
        }

    companion object {
        private const val USERNAME = "ha"
        private const val PASSWORD = "123"
    }
}