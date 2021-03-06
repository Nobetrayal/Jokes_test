package ru.makskol.jokes

import android.os.Bundle
import androidx.annotation.StringRes
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_jokes, R.id.navigation_web_api))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun Fragment.setActivityTitle(@StringRes id: Int)
    {
        (activity as AppCompatActivity?)!!.supportActionBar?.title = getString(id)
    }

    fun Fragment.setActivityTitle(title: String)
    {
        (activity as AppCompatActivity?)!!.supportActionBar?.title = title
    }

}