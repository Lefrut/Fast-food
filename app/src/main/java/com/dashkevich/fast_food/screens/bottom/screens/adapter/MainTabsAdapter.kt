package com.dashkevich.fast_food.screens.bottom.screens.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dashkevich.fast_food.screens.bottom.screens.tabs.TabFragment

class MainTabsAdapter(
    private val parentFragment: Fragment,
    private val tabs: List<Pair<Fragment,String>>
) : FragmentStateAdapter(parentFragment) {
    override fun getItemCount(): Int = tabs.size

    override fun createFragment(position: Int): Fragment = tabs[position].first
}