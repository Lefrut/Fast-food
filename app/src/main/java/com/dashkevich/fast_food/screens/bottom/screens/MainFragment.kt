package com.dashkevich.fast_food.screens.bottom.screens

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import com.dashkevich.fast_food.R
import com.dashkevich.fast_food.databinding.FragmentMainBinding
import com.dashkevich.fast_food.databinding.TabTitleBinding
import com.dashkevich.fast_food.screens.bottom.screens.adapter.BannerDecoration
import com.dashkevich.fast_food.screens.bottom.screens.adapter.MainTabsAdapter
import com.dashkevich.fast_food.screens.bottom.screens.adapter.bannerAdapterDelegates
import com.dashkevich.fast_food.screens.bottom.screens.tabs.TabFragment
import com.dashkevich.fast_food.util.getBanners
import com.dashkevich.fast_food.util.toPx
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainFragment : Fragment(R.layout.fragment_main) {

    lateinit var binding: FragmentMainBinding
    private val marketingAdapter = ListDelegationAdapter(
        bannerAdapterDelegates(onClick = {})
    )

    @SuppressLint("InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        //TODO - Засунуть во ViewModel
        marketingAdapter.items = getBanners(requireContext(), 12)

        val mainTabsAdapter = MainTabsAdapter(parentFragment = this, tabs = tabs)

        val viewPager = binding.viewPager
        viewPager.adapter = mainTabsAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { itemTab, position ->
            itemTab.text = tabs[position].second
        }.attach()
        for(indexTab in tabs.indices){
            val card = LayoutInflater.from(requireContext()).inflate(R.layout.tab_title, null, false) as CardView
            binding.tabLayout.getTabAt(indexTab)?.customView = card

        }


        with(binding.marketingRv) {
            addItemDecoration(BannerDecoration())
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = marketingAdapter
        }
    }

    private val tabs = listOf("Пицца", "Комбо", "Десерт", "Остальное").map { Pair(TabFragment.newInstance(it), it) }
}