package com.example.demotest.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.example.demotest.R
import com.example.demotest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar :Toolbar = binding.toolbar;

        setSupportActionBar(toolbar)

        val bottomNavigationView = binding.contentMain.bottomNavigationView
        val navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment).navController


        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.homeFragment,
            R.id.servicesFragment,
            R.id.profileFragment
        ))

        toolbar.setupWithNavController(navController,appBarConfiguration)

        //setupActionBarWithNavController(navController, appBarConfiguration)

       bottomNavigationView.setupWithNavController(navController)
        setSupportActionBar(toolbar)

    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

}