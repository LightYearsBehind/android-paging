package com.geniewits.paging3

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class TipsViewHolder(
    itemView: View,
    onClick: (tips: Tips) -> Unit
) : RecyclerView.ViewHolder(
    itemView
) {
    private val tipsView = itemView.findViewById<TextView>(R.id.tips)
    private var tips: Tips? = null

    init {
        itemView.setOnClickListener {
            tips?.run {
                onClick(this)
            }
        }
    }

    fun onBind(tips: Tips) {
        this.tips = tips
        tipsView.text = tips.content
    }
}