package com.asb.mobiletest.ui

import com.asb.network.model.Transaction

interface ClickCallBack {
    fun onListItemSelected(transaction: Transaction)
}