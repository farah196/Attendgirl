package com.example.farahal_kiswani.attendgirl.main

class NameModel {

    private var name: String? = null
    private var checked: Int? = null
    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name

    }


    fun getChecked(): Int? {
        return checked
    }

    fun setChecked(checked: Int?) {
        this.checked = checked

    }

}