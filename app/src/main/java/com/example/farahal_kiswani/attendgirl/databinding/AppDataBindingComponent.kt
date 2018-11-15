package com.example.farahal_kiswani.attendgirl.databinding

import android.databinding.DataBindingComponent


class AppDataBindingComponent :DataBindingComponent {
    override fun getRecyclerViewDataBinding(): RecyclerViewDataBinding {
        return RecyclerViewDataBinding()
    }

}