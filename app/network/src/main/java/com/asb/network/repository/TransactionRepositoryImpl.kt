package com.asb.network.repository

import androidx.lifecycle.MutableLiveData
import com.asb.network.model.Transaction
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionRepositoryImpl: TransactionRepository {

    private val transactions: MutableLiveData<List<Transaction>> = MutableLiveData()

    override fun getTransactions(): MutableLiveData<List<Transaction>> {
        val call: Call<List<Transaction>> =
            RetrofitService().retrofitServiceClient.transactionsList
        call.enqueue(object : Callback<List<Transaction>> {
            override fun onResponse(
                call: Call<List<Transaction>>,
                response: Response<List<Transaction>>
            ) {
                val transactionList: List<Transaction>? = response.body()
                transactions.value =  transactionList

            }

            override fun onFailure(call: Call<List<Transaction>>, t: Throwable) {
                transactions.value = null
            }
        })
        return transactions
    }
}