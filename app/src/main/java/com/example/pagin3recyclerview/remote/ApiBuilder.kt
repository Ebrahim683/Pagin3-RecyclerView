package com.example.pagin3recyclerview.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class ApiBuilder {

	val baseUrl = "https://quotable.io"

	private fun getRetrofit(): Retrofit {
		return Retrofit.Builder()
			.baseUrl(baseUrl)
			.addConverterFactory(ScalarsConverterFactory.create())
			.addConverterFactory(GsonConverterFactory.create())
			.build()
	}

	fun getApi(): ApiService = ApiBuilder().getRetrofit().create(ApiService::class.java)

}