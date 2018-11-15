package com.example.farahal_kiswani.attendgirl.main

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import java.util.ArrayList
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.FirebaseDatabase



class NameViewModel : BaseObservable() {

    private var adapter: NameAdapter? = null
    private var data: MutableList<NameModel>? = null

    init {
        data = ArrayList<NameModel>()
        adapter = NameAdapter()
    }

    fun setUp() {
        fetchData()
    }

//    fun drawer (mContext: Context, view: View, )
//    {
//    }
    @Bindable
    fun getData(): List<NameModel> {
        return this.data!!
    }

    @Bindable
    fun getAdapter(): NameAdapter {
        return this.adapter!!
    }

    private fun fetchData() {
        val rootRef = FirebaseDatabase.getInstance().reference
        val user = FirebaseAuth.getInstance().currentUser

        val itemsRef = rootRef.child("كورال").child(user!!.uid)
        val eventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (ds in dataSnapshot.children) {
                    val dataModel = NameModel()
                    val link = ds.key
                    dataModel.setName(link)
                    data!!.add(dataModel)
                    notifyPropertyChanged(com.example.farahal_kiswani.attendgirl.BR.data)
                    Log.d("link", link)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        }
        itemsRef.addListenerForSingleValueEvent(eventListener)

    }

}