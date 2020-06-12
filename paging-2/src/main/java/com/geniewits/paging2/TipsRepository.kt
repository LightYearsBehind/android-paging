package com.geniewits.paging2

import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

internal class TipsRepository(
    private val dataSourceFactory: TipsDataSourceFactory,
    private val pageSize: Int
) {
    private val items = mutableListOf<Tips>()

    init {
        for (i in 1..500) {
            items.add(Tips("Tips $i"))
        }

        dataSourceFactory.setItems(items.toList())
    }

    fun getLivePagedListBuilder(): LivePagedListBuilder<Tips, Tips> {
        return LivePagedListBuilder(
            dataSourceFactory,
            PagedList.Config.Builder().setPageSize(pageSize).build()
        )
    }
}