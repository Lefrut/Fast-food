package com.dashkevich.fast_food.util

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.dashkevich.fast_food.R
import com.dashkevich.fast_food.screens.bottom.screens.adapter.AdapterItemDelegate
import com.dashkevich.fast_food.screens.bottom.screens.adapter.BannerDelegate

fun getBanner(context: Context): Drawable {
    val banners = listOf(R.drawable.banner_pizza, R.drawable.dodo_banner)
    return ContextCompat.getDrawable(context, banners.random())!!
}

fun getBanners(context: Context, size: Int): List<AdapterItemDelegate> {
    val banners = try {
        List(size) { _ ->
            BannerDelegate(image = getBanner(context))
        }
    }catch (_: Exception){
        listOf<AdapterItemDelegate>()
    }
    return banners

}