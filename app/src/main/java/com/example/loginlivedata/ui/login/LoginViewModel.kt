package com.example.loginlivedata.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginlivedata.data.SharedPreferenceHelper
import com.example.loginlivedata.data.User

class LoginViewModel : ViewModel() {
    var isSuccess: MutableLiveData<Boolean> = MutableLiveData()

    fun clickLogin(username1: String, password1: String) =
        if (username1 == USERNAME && password1 == PASSWORD) {
            isSuccess.value = true
        } else {
            isSuccess.value = false
        }

    fun getUsername(): String {
        return SharedPreferenceHelper.getUsername()
    }

    fun getPassword(): String {
        return SharedPreferenceHelper.getPassword()
    }

    fun saveUsername(username: String) {
        SharedPreferenceHelper.saveUsername(username = username)
    }

    fun savePassword(password: String) {
        SharedPreferenceHelper.savePassword(password = password)
    }

    fun saveUser(user: User) {
        SharedPreferenceHelper.saveUser(user = user)
    }

    fun getUser(): User {
        return SharedPreferenceHelper.getUser()
    }

    fun saveSession(checked: Boolean) {
        SharedPreferenceHelper.saveLoginSession(save = checked)
    }

    fun isSessionSaved(): Boolean {
        return SharedPreferenceHelper.isSessionSaved()
    }

    companion object {
        private const val USERNAME = "ha"
        private const val PASSWORD = "123"
    }
}