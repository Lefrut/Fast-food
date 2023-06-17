package com.dashkevich.fast_food.screens.bottom.screens.adapter

import android.graphics.drawable.Drawable
import com.dashkevich.fast_food.databinding.BannerItemBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

class BannerDelegate(val image: Drawable) : AdapterItemDelegate {
    override fun id(): Any = image

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as BannerDelegate
        if (image != other.image) return false
        return true
    }

    override fun hashCode(): Int {
        return image.hashCode()
    }
}

inline fun bannerAdapterDelegates(onClick: () -> Unit) =
    adapterDelegateViewBinding<BannerDelegate, AdapterItemDelegate, BannerItemBinding>(
        viewBinding = { layoutInflater, root ->
            BannerItemBinding.inflate(layoutInflater, root, false)
        },
        on = { item, _, _ ->
            item is BannerDelegate
        }
    ) {
        bind {
            binding.bannerImg.setImageDrawable(item.image)
        }
    }
