package com.example.nutritionalapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.nutritionalapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        Timber.e("oncreate")
        var bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation);
        var navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment;

        NavigationUI.setupWithNavController(
            bottomNavigationView,
            navHostFragment.navController
        )

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            Timber.e("listener...?")
            when (item.itemId) {
                R.id.manualInputFragment -> {
                    Log.e("!!", "list clicked")
                    Timber.e("List clicked")
                    // Respond to navigation item 1 click
                    true
                }

                R.id.qrScanFragment -> {
                    Log.e("!!", "menu clicked")
                    Timber.e("Menu clicked")
                    // Respond to navigation item 2 click
                    true
                }

                else -> {
                    Log.e("!!", "lol")
                    Timber.e("lol")
                    false
                }
            }
        }
    }

    /*
            val itemSelectedListener =
                BottomNavigationView.OnNavigationItemSelectedListener { item ->
                    var selectedFragment: Fragment? = null
                    when (item.itemId) {
                        R.id.nav_icon1 -> selectedFragment = ManualInputFragment()
                        R.id.nav_icon2 -> selectedFragment = HomeFragment()

                    }

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment).commit()
                    true
                }*/

}