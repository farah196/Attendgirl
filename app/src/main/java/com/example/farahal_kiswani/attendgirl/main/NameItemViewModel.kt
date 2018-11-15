package com.example.farahal_kiswani.attendgirl.main

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.text.TextUtils

class NameItemViewModel (private val dataModel: NameModel): BaseObservable() {


    fun setUp() {
        // perform set up tasks, such as adding listeners
    }

    fun tearDown() {
        // perform tear down tasks, such as removing listeners
    }

    @Bindable
    fun getTitle(): String {
        return if (!TextUtils.isEmpty(dataModel.getName())) dataModel.getName()!! else ""
    }

    @Bindable
    fun getChecked(): Int {
        return if (!TextUtils.isEmpty(dataModel.getChecked().toString())) dataModel.getChecked()!! else 0
    }

}