package com.geniewits.paging3

import androidx.paging.Pager
import androidx.paging.PagingConfig

internal class TipsRepository(
    private val pageSize: Int
) {
    private val items = mutableListOf<Tips>()

    init {
        for (i in 1..500) {
            items.add(Tips("Tips $i"))
        }
    }

    fun getPager(): Pager<Tips, Tips> {
        return Pager(
            pagingSourceFactory = { TipsPagingSource(items.toList()) },
            config = PagingConfig(pageSize)
        )
    }
}