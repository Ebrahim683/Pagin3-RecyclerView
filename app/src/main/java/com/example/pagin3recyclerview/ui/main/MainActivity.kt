package com.example.pagin3recyclerview.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pagin3recyclerview.QuoteApp
import com.example.pagin3recyclerview.R
import com.example.pagin3recyclerview.paging.QuotesLoaderAdapter
import com.example.pagin3recyclerview.paging.QuotesPagingAdapter
import com.example.pagin3recyclerview.viewmodel.QuotesViewModel
import com.example.pagin3recyclerview.viewmodel.ViewModelFactory

private const val TAG = "mainActivity"

class MainActivity : AppCompatActivity() {

	private lateinit var recyclerView: RecyclerView
	private lateinit var quotesPagingAdapter: QuotesPagingAdapter
	private lateinit var quotesLoaderAdapter: QuotesLoaderAdapter
	private val viewModel by viewModels<QuotesViewModel> {
		ViewModelFactory((application as QuoteApp).repository)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		recyclerView = findViewById(R.id.rec_id)
		quotesPagingAdapter = QuotesPagingAdapter()
		quotesLoaderAdapter = QuotesLoaderAdapter()

		recyclerView.layoutManager = LinearLayoutManager(this)
		recyclerView.setHasFixedSize(true)
		recyclerView.adapter = quotesPagingAdapter.withLoadStateFooter(
			footer = quotesLoaderAdapter
		)

		viewModel.list.observe(this, Observer {
			Log.d(TAG, "onCreate: $it")
			quotesPagingAdapter.submitData(lifecycle, it)
		})

	}
}