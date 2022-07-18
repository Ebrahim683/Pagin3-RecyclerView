package com.example.pagin3recyclerview.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagin3recyclerview.data.Result
import com.example.pagin3recyclerview.remote.ApiBuilder

class QuotesPagingSource(private val apiBuilder: ApiBuilder) : PagingSource<Int, Result>() {

	override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
		val page = params.key ?: 1
		return try {
			val response = apiBuilder.getApi().getQuote(page)
			LoadResult.Page(
				data = response.results,
				prevKey = if (page == 1) null else page - 1,
				nextKey = if (page == response.totalPages) null else page + 1
			)
		} catch (e: Exception) {
			LoadResult.Error(e)
		}
	}

	override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
		return state.anchorPosition?.let { anchorPosition ->
			val anchorPage = state.closestPageToPosition(anchorPosition)
			anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
		}
	}
}