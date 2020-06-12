package com.geniewits.paging3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil

internal class TipsAdapter(
    differ: DiffUtil.ItemCallback<Tips>,
    private val onClick: (tips: Tips) -> Unit
) : PagingDataAdapter<Tips, TipsViewHolder>(
    differ
) {
    companion object {
        private fun ViewGroup.inflate(@LayoutRes layout: Int) =
            LayoutInflater.from(context).inflate(layout, this, false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TipsViewHolder(parent.inflate(R.layout.tips), onClick)

    override fun onBindViewHolder(holder: TipsViewHolder, position: Int) {
        holder.onBind(getItem(position)!!)
    }
}