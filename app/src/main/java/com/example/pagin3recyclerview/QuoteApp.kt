package com.example.pagin3recyclerview

import android.app.Application
import com.example.pagin3recyclerview.remote.ApiBuilder
import com.example.pagin3recyclerview.repository.QuotesRepository

class QuoteApp : Application() {

	val repository by lazy {
		QuotesRepository(ApiBuilder())
	}

}