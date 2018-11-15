package com.example.farahal_kiswani.attendgirl.login

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.farahal_kiswani.attendgirl.R
import com.example.farahal_kiswani.attendgirl.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = LoginViewModel(mContext = this)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewLogin = model


    }
}
