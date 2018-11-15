package com.example.farahal_kiswani.attendgirl.addInfo


import android.databinding.DataBindingUtil

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.farahal_kiswani.attendgirl.R
import com.example.farahal_kiswani.attendgirl.databinding.ActivityAddinfoBinding


class AddInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addinfo)


        val model = AddInfoViewModel(mContext = this)
        val binding: ActivityAddinfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_addinfo)
        binding.viewAdd = model


    }


}