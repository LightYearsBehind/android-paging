package com.geniewits.paging2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList

internal class TipsViewModel(private val repository: TipsRepository) : ViewModel() {
    fun getTipsStream(): LiveData<PagedList<Tips>> {
        return repository.getLivePagedListBuilder().build()
    }
}