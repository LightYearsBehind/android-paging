package com.geniewits.paging3

import android.util.Log
import androidx.paging.PagingSource

internal class TipsPagingSource(
    private val items: List<Tips>
) : PagingSource<Tips, Tips>() {
    override suspend fun load(params: LoadParams<Tips>): LoadResult<Tips, Tips> {
        val index = params.key?.run { items.indexOf(this) } ?: run { -1 }
        val (firstIndex, lastIndex) = when (params) {
            is LoadParams.Prepend -> {
                val lastIndex = index
                val firstIndex = (lastIndex - params.loadSize).coerceAtLeast(0)
                Pair(firstIndex, lastIndex)
            }
            is LoadParams.Append, is LoadParams.Refresh -> {
                val firstIndex = index + 1
                val lastIndex = (firstIndex + params.loadSize).coerceAtMost(items.size)
                Pair(firstIndex, lastIndex)
            }
        }

        val data = items.subList(firstIndex, lastIndex)
        val previousKey = if (firstIndex > 0) params.key else null
        val nextKey = if (lastIndex < items.size) data.last() else null

        Log.d("MY_PAGING", "size -> ${data.size}, firstIndex -> $firstIndex, lastIndex -> $lastIndex")

        return LoadResult.Page(data, previousKey, nextKey)
    }
}