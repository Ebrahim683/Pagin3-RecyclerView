package com.example.pagin3recyclerview.remote

import com.example.pagin3recyclerview.data.QuoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

	@GET("/quotes")
	suspend fun getQuote(
		@Query("page") page: Int?
	): QuoteModel

}