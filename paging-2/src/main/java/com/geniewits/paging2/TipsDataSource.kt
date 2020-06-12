package com.geniewits.paging2

import androidx.paging.ItemKeyedDataSource

internal class TipsDataSource(
    private val items: List<Tips>
) : ItemKeyedDataSource<Tips, Tips>(
) {
    override fun getKey(item: Tips) = item

    override fun loadInitial(
        params: LoadInitialParams<Tips>,
        callback: LoadInitialCallback<Tips>
    ) {
        val index = indexOf(params.requestedInitialKey)
        val firstIndex = if (index != -1) index else 0
        val lastIndex = (firstIndex + params.requestedLoadSize).coerceAtMost(items.size)
        val data = getItems(firstIndex, lastIndex)
        callback.onResult(data, 0, items.size)
    }

    override fun loadAfter(params: LoadParams<Tips>, callback: LoadCallback<Tips>) {
        val firstIndex = indexOf(params.key) + 1
        val lastIndex = (firstIndex + params.requestedLoadSize).coerceAtMost(items.size)
        val data = getItems(firstIndex, lastIndex)
        callback.onResult(data)
    }

    override fun loadBefore(params: LoadParams<Tips>, callback: LoadCallback<Tips>) {
        val lastIndex = indexOf(params.key)
        val firstIndex = (lastIndex - params.requestedLoadSize).coerceAtLeast(0)
        val data = getItems(firstIndex, lastIndex)
        callback.onResult(data)
    }

    private fun indexOf(tips: Tips?) = if (tips != null) items.indexOf(tips) else -1
    private fun getItems(start: Int, end: Int) = items.subList(start, end)
}