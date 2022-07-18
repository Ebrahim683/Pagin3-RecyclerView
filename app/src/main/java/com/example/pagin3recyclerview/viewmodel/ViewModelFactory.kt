package com.example.pagin3recyclerview.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pagin3recyclerview.repository.QuotesRepository

class ViewModelFactory(private val repository: QuotesRepository):ViewModelProvider.Factory {
	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		return (QuotesViewModel(repository)) as T
	}
}