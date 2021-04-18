package com.asb.mobiletest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.asb.mobiletest.util.GSTUtil
import com.asb.network.model.Transaction
import com.asb.network.repository.TransactionRepositoryImpl

class TransactionViewModel(private val repositoryImpl: TransactionRepositoryImpl): ViewModel() {

    // Get the transactions from Repository and apply business logic
    fun getTransactions(): LiveData<List<Transaction>> {
        val updatedTransactionsList = Transformations.map(repositoryImpl.getTransactions()) { transactions ->
            updateGst(transactions)
        }
        return updatedTransactionsList
    }

    // Update the the data recived from repository before pass it on to the View.(Sorting & GST)
   private fun updateGst(transactionList: List<Transaction>): List<Transaction> {
       val newTransactionList = transactionList?.sortedBy { selector(it) }
       newTransactionList.forEach {
           it.gst = getGSTAmount(it)
       }
       return newTransactionList
   }

    // The sorting of the list is based on Credit value. This can be made configurable.
    private fun selector(transaction: Transaction): Double = transaction.credit

    // GST is calculated based on the Debit or Credit value.
    // If either one of them is not 0, then took the 15% to calculate GST( Based on assumption , might be wrong)
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