package com.example.pagin3recyclerview.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.pagin3recyclerview.paging.QuotesPagingSource
import com.example.pagin3recyclerview.remote.ApiBuilder

class QuotesRepository(private val apiBuilder: ApiBuilder) {
	fun getQuotes() = Pager(
		PagingConfig(pageSize = 20, maxSize = 100),
		pagingSourceFactory = { QuotesPagingSource(apiBuilder) }
	).liveData
}