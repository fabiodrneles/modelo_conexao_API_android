package com.fabiodrneles.myapp

import retrofit2.http.GET

interface ApiService {
    @GET("stone-pagamentos/desafio-mobile/master/store/products.json")
    suspend fun getProdutos(): List<Produto>
}