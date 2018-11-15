package com.example.farahal_kiswani.attendgirl.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.widget.Toast
import com.example.farahal_kiswani.attendgirl.main.MainActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class LoginModel(val mContext: Context) {
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun toastMsg(mText: String) {
        Toast.makeText(mContext, mText, android.widget.Toast.LENGTH_SHORT).show()
    }


    fun OpenMainActivity() {
        val intent = Intent(mContext, MainActivity::class.java)
        ContextCompat.startActivity(mContext, intent, Bundle())
    }

    fun login(email: String, password: String) {
        if (TextUtils.isEmpty(email)) {
            toastMsg("أدخل البريد الإلكتروني")

        }

        if (TextUtils.isEmpty(password)) {
            toastMsg("أدخل كلمة السر")

        } else {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task: Task<AuthResult> ->

                if (task.isSuccessful) {

                    OpenMainActivity()

                    //  val firebaseUser = this.auth.currentUser!!
                } else {

                    toastMsg("خطا في الايميل او الباسوورد")


                }
            }
        }
    }
}