package com.example.farahal_kiswani.attendgirl.addInfo

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.ObservableField
import android.view.View


class AddInfoViewModel(val mContext: Context) : BaseObservable() {

    val name = ObservableField<String>("")
    val age = ObservableField<String>("")
    private val dataModel= AddModel(mContext)
    // private var data: MutableList<AddModel>? = null


    //    @Bindable
//    fun getData(): List<AddModel> {
//        return this.data!!
//    }
    fun addInfo(view: View, name: String, age: String) {

        dataModel.addData(name, age)

    }
}


