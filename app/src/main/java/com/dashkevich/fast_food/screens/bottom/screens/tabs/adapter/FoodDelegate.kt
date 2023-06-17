package com.dashkevich.fast_food.screens.bottom.screens.tabs.adapter

import coil.load
import com.dashkevich.fast_food.R
import com.dashkevich.fast_food.databinding.BannerItemBinding
import com.dashkevich.fast_food.databinding.FoodItemBinding
import com.dashkevich.fast_food.screens.bottom.screens.adapter.AdapterItemDelegate
import com.dashkevich.fast_food.screens.bottom.screens.adapter.BannerDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

class FoodDelegate(
    val imgUrl: String,
    val id: String, val title: String,
    val desc: String
) : AdapterItemDelegate {
    override fun id(): Any = id

    override fun hashCode(): Int {
        var result = imgUrl.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + desc.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FoodDelegate

        if (imgUrl != other.imgUrl) return false
        if (id != other.id) return false
        if (title != other.title) return false
        if (desc != other.desc) return false

        return true
    }
}

inline fun foodDelegatesAdapter(onClick: () -> Unit) =
    adapterDelegateViewBinding<FoodDelegate, AdapterItemDelegate, FoodItemBinding>(
        viewBinding = { layoutInflater, root ->
            FoodItemBinding.inflate(layoutInflater, root, false)
        },
        on = { item, _, _ ->
            item is FoodDelegate
        }
    ) {
        bind {
            binding.apply {
                foodTitle.text = item.title
                foodButton.text = getString(R.string._345)
                foodDesc.text = item.desc
                foodImg.load(item.imgUrl)
            }
        }
    }
