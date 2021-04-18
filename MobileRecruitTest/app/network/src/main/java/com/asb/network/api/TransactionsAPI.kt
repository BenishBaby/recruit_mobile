package com.asb.network.api

import com.asb.network.model.Transaction
import retrofit2.Call
import retrofit2.http.GET

interface TransactionsAPI {
    @get:GET("transactions")
    val transactionsList: Call<List<Transaction?>?>?
}