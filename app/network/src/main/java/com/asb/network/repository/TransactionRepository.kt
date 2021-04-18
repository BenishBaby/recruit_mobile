package com.asb.network.repository

import androidx.lifecycle.MutableLiveData
import com.asb.network.model.Transaction

interface TransactionRepository {
    fun getTransactions(): MutableLiveData<List<Transaction>>
}