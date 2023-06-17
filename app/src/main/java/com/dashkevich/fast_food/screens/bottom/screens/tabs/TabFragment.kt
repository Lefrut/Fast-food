package com.dashkevich.fast_food.screens.bottom.screens.tabs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dashkevich.fast_food.R
import com.dashkevich.fast_food.databinding.FragmentTabBinding
import com.dashkevich.fast_food.screens.bottom.screens.MainViewModel
import com.dashkevich.fast_food.screens.bottom.screens.adapter.bannerAdapterDelegates
import com.dashkevich.fast_food.screens.bottom.screens.tabs.adapter.FoodDelegate
import com.dashkevich.fast_food.screens.bottom.screens.tabs.adapter.foodDelegatesAdapter
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class TabFragment : Fragment(R.layout.fragment_tab) {

    private lateinit var binding: FragmentTabBinding
    private val viewModel by viewModel<MainViewModel>()
    private val tabAdapter = ListDelegationAdapter(
        foodDelegatesAdapter(onClick = {})
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTabBinding.bind(view)
        val tabName = arguments?.getString(TAB_NAME)



        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewState.collect { mainModel ->

                    Log.i("FragmentDebug", "onViewCreated: mainModel - ${mainModel.personRequest}")
                    Log.i("FragmentDebug", "onViewCreated: ready - ${mainModel.ready}")


                    tabAdapter.items = mainModel.personRequest?.results?.map {
                        FoodDelegate(
                            imgUrl = it?.picture?.large ?: "",
                            title = it?.name?.title ?: "",
                            desc = it?.name?.last ?: "",
                            id = it?.id?.name ?: ""
                        )
                    }

                    binding.rv.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = tabAdapter
                    }

                }
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(tabName: String): Fragment = TabFragment().apply {
            arguments = Bundle().apply {
                putString(TAB_NAME, tabName)
            }
        }

        const val TAB_NAME = "tab_name"
    }
}