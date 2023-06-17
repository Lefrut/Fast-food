package com.dashkevich.fast_food.screens.bottom.screens.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dashkevich.fast_food.util.toPx
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder

class BannerDecoration() : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            val adapter = parent.adapter ?: return
            val currentPosition =
                parent.getChildAdapterPosition(view)
                    .takeIf { it != RecyclerView.NO_POSITION } ?: return
            val vh = parent.getChildViewHolder(view)
            if (vh is AdapterDelegateViewBindingViewHolder<*, *>) {
                if (vh.item !is BannerDelegate) return
            }

            top = 16
            bottom = 12
            right = 8
            when (currentPosition) {
                0 -> {
                    left = 16
                }
                adapter.itemCount - 1 -> {
                    left = 8
                    right = 16
                }
                else -> {
                    left = 8
                }
            }
            outRect.set(left.toPx, top.toPx, right.toPx, bottom.toPx)
        }
    }

}