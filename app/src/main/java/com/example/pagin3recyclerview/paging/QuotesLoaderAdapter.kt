package com.example.pagin3recyclerview.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pagin3recyclerview.R

class QuotesLoaderAdapter : LoadStateAdapter<QuotesLoaderAdapter.QuotesLoaderHolder>() {
	class QuotesLoaderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val sample_loader: ProgressBar = itemView.findViewById(R.id.sample_loader)

		fun bind(loadState: LoadState) {
			sample_loader.isVisible = loadState is LoadState.Loading
		}
	}

	override fun onBindViewHolder(holder: QuotesLoaderHolder, loadState: LoadState) {
		holder.bind(loadState)
	}

	override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): QuotesLoaderHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.loder_layout, parent, false)
		return QuotesLoaderHolder(view)
	}
}