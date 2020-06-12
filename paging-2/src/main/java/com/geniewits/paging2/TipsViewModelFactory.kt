package com.geniewits.paging2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

internal class TipsViewModelFactory(
    private val repository: TipsRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TipsViewModel(repository) as T
    }
}