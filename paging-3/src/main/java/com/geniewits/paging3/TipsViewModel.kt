package com.geniewits.paging3

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

internal class TipsViewModel(
    private val repository: TipsRepository
) : ViewModel() {
    fun getTipsStream(): Flow<PagingData<Tips>> {
        return repository.getPager().flow
    }
}