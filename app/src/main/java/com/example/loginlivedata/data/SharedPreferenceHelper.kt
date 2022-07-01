package com.example.loginlivedata.data

import android.content.Context
import android.content.SharedPreferences
import com.example.loginlivedata.data.Constants.NAME
import com.example.loginlivedata.data.Constants.PASSWORD
import com.example.loginlivedata.data.Constants.SAVE_SESSION
import com.example.loginlivedata.data.Constants.USER_KEY
import com.google.gson.Gson

object SharedPreferenceHelper {
    private var sharedPreference: SharedPreferences? = null
    private var json: Gson = Gson()
    fun init(context: Context) {
        sharedPreference =
            context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun saveUsername(username: String) {
        with(sharedPreference!!.edit()) {
            putString(NAME, username)
            apply()
        }
    }

    fun getUsername(): String {
        return sharedPreference?.getString(NAME, "") ?: ""
    }

    fun savePassword(password: String) {
        with(sharedPreference!!.edit()) {
            putString(PASSWORD, password)
            apply()
        }
    }

    fun getPassword(): String {
        return sharedPreference?.getString(PASSWORD, "") ?: ""
    }

    fun saveLoginSession(save: Boolean) {
        with(sharedPreference!!.edit()) {
            putBoolean(SAVE_SESSION, save)
            apply()
        }
    }

    fun isSessionSaved(): Boolean {
        return sharedPreference!!.getBoolean(SAVE_SESSION, false)
    }

    fun saveUser(user: User) {
        with(sharedPreference!!.edit()) {
            putString(USER_KEY, json.toJson(user))
            apply()
        }
    }

    fun getUser(): User {
        val userString = sharedPreference?.getString(USER_KEY, "")
        return json.fromJson(userString, User::class.java)
    }

}

