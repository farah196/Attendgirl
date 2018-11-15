package com.example.farahal_kiswani.attendgirl.login

import android.content.Context
import android.content.Intent
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableField
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.example.farahal_kiswani.attendgirl.BR
import com.example.farahal_kiswani.attendgirl.main.MainActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel(var mContext: Context) : BaseObservable() {

    private val model: LoginModel = LoginModel(mContext)
    private var isLoading: Boolean = false
    val email = ObservableField<String>("")
    val password = ObservableField<String>("")


    fun login(view: View, email: String, password: String) {
        model.login(email, password)
        setLoading(true)

    }


    @Bindable
    fun isLoading(): Boolean {
        return isLoading
    }

    fun setLoading(loading: Boolean) {
        isLoading = loading
        notifyPropertyChanged(BR._all)
    }
}