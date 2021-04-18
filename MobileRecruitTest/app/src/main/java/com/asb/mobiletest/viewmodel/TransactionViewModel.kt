package com.asb.mobiletest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.asb.mobiletest.util.GSTUtil
import com.asb.network.model.Transaction
import com.asb.network.repository.TransactionRepositoryImpl

class TransactionViewModel(private val repositoryImpl: TransactionRepositoryImpl): ViewModel() {

    fun getTransactions(): LiveData<List<Transaction>> {
        return repositoryImpl.getTransactions()
    }



    private fun getGSTAmount(transaction: Transaction): Double {
        val credit = transaction.credit
        val debit = transaction.debit
        return if(credit > 0) {
            GSTUtil.calculateGST(credit)
        } else if(debit > 0) {
            GSTUtil.calculateGST(debit)
        } else {
            0.0
        }
    }
}