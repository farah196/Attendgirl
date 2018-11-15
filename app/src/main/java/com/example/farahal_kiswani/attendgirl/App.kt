package com.example.farahal_kiswani.attendgirl

import android.app.Application
import android.databinding.DataBindingUtil
import com.example.farahal_kiswani.attendgirl.databinding.AppDataBindingComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DataBindingUtil.setDefaultComponent(AppDataBindingComponent())
    }
}