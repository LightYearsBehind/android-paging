package com.geniewits.paging2

import androidx.paging.DataSource

internal class TipsDataSourceFactory : DataSource.Factory<Tips, Tips>() {
    private lateinit var items: List<Tips>

    override fun create(): DataSource<Tips, Tips> {
        return TipsDataSource(items.toList())
    }

    fun setItems(items: List<Tips>) {
        this.items = items
    }
}