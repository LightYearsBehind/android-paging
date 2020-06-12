package com.geniewits.paging2

import androidx.recyclerview.widget.DiffUtil

internal class TipsDiffer : DiffUtil.ItemCallback<Tips>() {
    override fun areItemsTheSame(oldItem: Tips, newItem: Tips) = (oldItem == newItem)
    override fun areContentsTheSame(oldItem: Tips, newItem: Tips) = true
}