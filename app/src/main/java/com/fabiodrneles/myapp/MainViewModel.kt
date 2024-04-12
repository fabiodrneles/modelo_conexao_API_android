package com.fabiodrneles.myapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val apiService = RetrofitInstance.api
    val produtos: MutableState<List<Produto>> = mutableStateOf(emptyList())
    fun getProdutos() {
        viewModelScope.launch {
            try {
                val response = apiService.getProdutos()
                if (response.isNotEmpty()) {
                    produtos.value = response
                }
            } catch (e: Exception) {
                // Handle errors here
            }
        }
    }
}