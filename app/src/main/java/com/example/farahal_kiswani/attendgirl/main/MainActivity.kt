package com.example.farahal_kiswani.attendgirl.main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import com.example.farahal_kiswani.attendgirl.R
import com.example.farahal_kiswani.attendgirl.addInfo.AddInfo
import com.example.farahal_kiswani.attendgirl.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var dataViewModel: NameViewModel = NameViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = bind()
        initRecyclerView(view)
        initDrawer(view)
    }


    override fun onResume() {
        super.onResume()
        dataViewModel.setUp()
    }


    private fun bind(): View {
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.viewList = dataViewModel
        return binding.getRoot()
    }

    private fun initRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.mNameRecycler)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, true)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL))

    }

    private fun initDrawer(view: View) {
        val toolbar: Toolbar = view.findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        val mDrawerToggle: ActionBarDrawerToggle?
        mDrawerToggle = object :
            ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            override fun onDrawerClosed(view: View) {
                super.onDrawerClosed(view)

            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                //toast("Drawer opened")
            }
        }


        drawer_layout!!.addDrawerListener(mDrawerToggle)
        mDrawerToggle.setDrawerIndicatorEnabled(true)

        mDrawerToggle.syncState()

        navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mAdd -> {
                    val intent = Intent(this, AddInfo::class.java)
                    startActivity(intent)
                }

            }
            // Close the drawer
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
    }


}


