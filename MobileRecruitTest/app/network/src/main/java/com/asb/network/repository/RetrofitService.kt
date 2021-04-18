package com.asb.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    val retrofitServiceClient: StoresAPI
        get() {
            val gson: Gson = GsonBuilder()
                .setLenient()
                .create()
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            return retrofit.create(StoresAPI::class.java)
        }

    companion object {
        const val BASE_URL = "https://mopjapaneastgateway.plexure.io/store/v2/"
    }
}