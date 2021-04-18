package com.asb.mobiletest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.asb.network.repository.TransactionRepositoryImpl

class TransactionViewModelFactory(private val repositoryImpl: TransactionRepositoryImpl):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TransactionViewModel(repositoryImpl) as T
    }
}