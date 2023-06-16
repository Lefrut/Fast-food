package com.dashkevich.fast_food

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.dashkevich.fast_food.util.configSystemUI

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configSystemUI(window, resources)

        navController = (supportFragmentManager.findFragmentById(R.id.root_container) as NavHostFragment)
            .navController
        navController.setGraph(R.navigation.root_nav_graph)
    }


}