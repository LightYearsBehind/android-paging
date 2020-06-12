package com.geniewits.paging2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Paging2Fragment : Fragment() {
    private val tipsAdapter = TipsAdapter(TipsDiffer()) { onClick(it) }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val dataSourceFactory = TipsDataSourceFactory()
        val repository = TipsRepository(dataSourceFactory, 30)
        val vmProviderFactory = TipsViewModelFactory(repository)
        val vm = ViewModelProvider(viewModelStore, vmProviderFactory)[TipsViewModel::class.java]
        vm.getTipsStream().observe(this, Observer { tipsAdapter.submitList(it) })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return (inflater.inflate(R.layout.list, container, false) as RecyclerView).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = tipsAdapter
        }
    }

    private fun onClick(tips: Tips) {
        Toast.makeText(activity, "Paging 2 -> ${tips.content}", Toast.LENGTH_SHORT).show()
    }
}