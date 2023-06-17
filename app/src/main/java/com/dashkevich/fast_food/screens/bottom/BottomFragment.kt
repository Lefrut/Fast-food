package com.dashkevich.fast_food.screens.bottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.dashkevich.fast_food.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomFragment : Fragment(R.layout.fragment_bottom) {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBottomNavigation(view)
    }

    private fun initBottomNavigation(view: View){
        val navHost =
            childFragmentManager.findFragmentById(R.id.bottom_container) as NavHostFragment
        navController = navHost.navController
        navController.setGraph(R.navigation.bottom_nav_graph)
        val bottomBar = view.findViewById<BottomNavigationView>(R.id.bottom_bar)
        bottomBar.setupWithNavController(navController)
    }
}