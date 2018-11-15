package com.example.farahal_kiswani.attendgirl.addInfo


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.widget.Toast
import com.example.farahal_kiswani.attendgirl.main.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddModel(val mContext: Context) {
  fun toastMsg(mText: String) {
        Toast.makeText(mContext, mText, android.widget.Toast.LENGTH_SHORT).show()
    }

    fun openMainActivity() {
        val intent = Intent(mContext, MainActivity::class.java)
        ContextCompat.startActivity(mContext, intent, Bundle())
    }
    fun addData(name: String, age: String) {
        if (TextUtils.isEmpty(name)) {
            toastMsg("أدخل الاسم")
        }

        if (TextUtils.isEmpty(age)) {
            toastMsg("أدخل العمر")
        }
        else {
            val user = FirebaseAuth.getInstance().currentUser

            val databaseReference: DatabaseReference =
                FirebaseDatabase.getInstance().reference.child("user").child(user!!.uid).child(name)

            val info = Info(name, age)

            databaseReference.setValue(info)
            toastMsg("تم حفظ المعلومات بنجاح..")
            openMainActivity()
        }
    }
    }
