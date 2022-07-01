package com.example.loginlivedata

import android.app.Application
import com.example.loginlivedata.data.SharedPreferenceHelper

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPreferenceHelper.init(context = this.applicationContext)
    }
}