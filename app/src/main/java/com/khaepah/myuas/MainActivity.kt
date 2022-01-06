package com.khaepah.myuas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val navController = Navigation.findNavController(this, R.id.fragment_container)
        NavigationUI.setupWithNavController(nav_view, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, dw_layout)

        val toggle = ActionBarDrawerToggle(this, dw_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close )
        dw_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if (dw_layout.isDrawerOpen(GravityCompat.START)) {
            dw_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}