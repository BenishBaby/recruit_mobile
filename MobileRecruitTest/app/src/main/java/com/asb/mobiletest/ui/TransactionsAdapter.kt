package com.asb.mobiletest.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asb.mobiletest.R
import com.asb.network.model.Transaction
import java.lang.String

class TransactionsAdapter(private val context: Context, private val transactionList: List<Transaction>,private val clickCallBack: ClickCallBack) : RecyclerView.Adapter<TransactionItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionItemViewHolder {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return TransactionItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    override fun onBindViewHolder(holder: TransactionItemViewHolder, position: Int) {
        val transaction: Transaction = transactionList[position]
        holder.tvTransactionId.text = transaction.id
        holder.tvTransactionDate.text = transaction.transactionDate
        holder.tvSummary.text = transaction.summary
        holder.tvDebit.text = String.valueOf(transaction.debit)
        holder.tvCredit.text = String.valueOf(transaction.debit)
        holder.view.setOnClickListener {
            clickCallBack.onListItemSelected(transactionList[position])
        }
    }

}