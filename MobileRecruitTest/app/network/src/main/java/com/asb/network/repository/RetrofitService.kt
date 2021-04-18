package com.asb.network.repository

import com.asb.network.api.TransactionsAPI
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    val retrofitServiceClient: TransactionsAPI
        get() {
            val gson: Gson = GsonBuilder()
                .setLenient()
                .create()
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            return retrofit.create(TransactionsAPI::class.java)
        }

    companion object {
        const val BASE_URL = " https://60220907ae8f8700177dee68.mockapi.io/api/v1/"
    }
}