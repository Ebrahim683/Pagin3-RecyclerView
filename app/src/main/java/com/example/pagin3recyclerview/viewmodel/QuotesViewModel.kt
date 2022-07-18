package com.example.pagin3recyclerview.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.pagin3recyclerview.repository.QuotesRepository

class QuotesViewModel(private val quotesRepository: QuotesRepository) : ViewModel() {

	val list = quotesRepository.getQuotes().cachedIn(viewModelScope)

}