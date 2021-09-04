package com.myself.mynotebook.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.myself.mynotebook.R

class MainActivity : AppCompatActivity() {

    var my_drawarLayout: DrawerLayout? = null;
    var img_Menu : AppCompatImageView ?=null;
    var txt_title: AppCompatTextView?=null;
    var nav_myDawar: NavigationView?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instance();
        clickEvent();
        setupPage();
    }

    private fun setupPage() {
        val navController = Navigation.findNavController(this,R.id.fragment)
        nav_myDawar?.let { NavigationUI.setupWithNavController(it,navController) }
        navController
            .addOnDestinationChangedListener { controller, destination, arguments ->
                txt_title?.text = destination.label
            }
    }

    private fun clickEvent() {

        nav_myDawar?.itemIconTintList = null
        img_Menu?.setOnClickListener {
            my_drawarLayout?.openDrawer(GravityCompat.START)
        }
    }

    private fun instance() {
        my_drawarLayout=findViewById(R.id.my_drawarLayout);
        img_Menu=findViewById(R.id.img_Menu);
        txt_title=findViewById(R.id.txt_title);
        nav_myDawar=findViewById(R.id.nav_myDawar);
    }
}