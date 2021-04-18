package com.asb.mobiletest.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.asb.mobiletest.R

class TransactionItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    val tvTransactionId: TextView = view.findViewById(R.id.transaction_id)
    val tvTransactionDate: TextView = view.findViewById(R.id.transaction_date)
    val tvSummary: TextView = view.findViewById(R.id.summary)
    val tvDebit: TextView = view.findViewById(R.id.debit)
    val tvCredit: TextView = view.findViewById(R.id.credit)
    val tvGST: TextView = view.findViewById(R.id.credit)
}
