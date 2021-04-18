package com.asb.mobiletest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asb.network.model.Transaction
import com.asb.network.repository.TransactionRepositoryImpl

class TransactionViewModel(private val repositoryImpl: TransactionRepositoryImpl): ViewModel() {

    fun getTransactions(): LiveData<List<Transaction>> {
        return repositoryImpl.getTransactions()
    }
}