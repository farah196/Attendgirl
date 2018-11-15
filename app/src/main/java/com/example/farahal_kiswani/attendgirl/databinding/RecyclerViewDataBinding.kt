package com.example.farahal_kiswani.attendgirl.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.example.farahal_kiswani.attendgirl.main.NameAdapter
import com.example.farahal_kiswani.attendgirl.main.NameModel

class RecyclerViewDataBinding {
    @BindingAdapter("app:adapter", "app:data")
    fun bind(recyclerView: RecyclerView, adapter: NameAdapter, data: List<NameModel>) {
        recyclerView.adapter = adapter
        adapter.updateData(data)
    }
}