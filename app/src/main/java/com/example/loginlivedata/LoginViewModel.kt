package com.example.loginlivedata

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

class LoginViewModel : ViewModel() {
    private lateinit var navController: NavController
    val username: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()
    var isSuccess: Boolean = false
    var activity = MainActivity()

    fun clickLogin(username1:String, password1:String) {
        if (username1 == "ha" && password1 == "123") {
            isSuccess = true
            username.value = username1
            password.value = password1
            navController.navigate(R.id.action_loginFragment2_to_homeFragment)
        } else if (username1.isEmpty() || password1.isEmpty()) {
            isSuccess = false
            Toast.makeText(activity, "Khong duoc de trong", Toast.LENGTH_SHORT).show()
        } else {
            isSuccess = false
            Toast.makeText(activity, "Login Fail", Toast.LENGTH_SHORT).show()
        }
    }
}