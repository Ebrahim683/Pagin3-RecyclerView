package com.example.pagin3recyclerview.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pagin3recyclerview.R
import com.example.pagin3recyclerview.data.Result

class QuotesPagingAdapter :
	PagingDataAdapter<Result, QuotesPagingAdapter.QuotesPagingHolder>(diffUtil) {

	companion object {
		val diffUtil = object : DiffUtil.ItemCallback<Result>() {
			override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
				return oldItem.id == newItem.id
			}

			override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
				return oldItem.id == newItem.id
			}

		}
	}

	class QuotesPagingHolder(view: View) : RecyclerView.ViewHolder(view) {
		val sample_text: TextView = view.findViewById(R.id.sample_text)

		fun bind(result: Result) {
			sample_text.text = result.content
		}
	}

	override fun onBindViewHolder(holder: QuotesPagingHolder, position: Int) {
		val result = getItem(position)
		if (result != null) {
			holder.bind(result)
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesPagingHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.single_row, parent, false)
		return QuotesPagingHolder(view)
	}
}