package com.dashkevich.fast_food.util

import android.content.res.Configuration
import android.content.res.Resources
import android.view.Window
import androidx.core.view.WindowInsetsControllerCompat

internal fun configSystemUI(window: Window, resources: Resources) {
    val wic = WindowInsetsControllerCompat(window, window.decorView)
    when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
        Configuration.UI_MODE_NIGHT_NO -> {
            wic.isAppearanceLightStatusBars = true
            wic.isAppearanceLightNavigationBars = true
        }
        Configuration.UI_MODE_NIGHT_YES -> {
            wic.isAppearanceLightStatusBars = true
            wic.isAppearanceLightNavigationBars = true
        }
    }
}