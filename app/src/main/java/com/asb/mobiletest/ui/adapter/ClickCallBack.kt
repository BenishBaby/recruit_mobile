package com.asb.mobiletest.ui.adapter

import com.asb.network.model.Transaction

interface ClickCallBack {
    fun onListItemSelected(transaction: Transaction)
}