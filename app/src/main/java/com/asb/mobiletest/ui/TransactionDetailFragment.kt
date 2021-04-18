package com.asb.mobiletest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import com.asb.mobiletest.R
import com.asb.network.model.Transaction
import java.lang.String

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TransactionDetailFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("requestKey") { _, bundle ->
            val result = bundle.getParcelable<Transaction>("transaction")
            displayTransactionDetails(result)
        }
    }

    private fun displayTransactionDetails(transaction: Transaction?) {
        transaction?.let {
            view?.findViewById<TextView>(R.id.transaction_id)?.text = transaction.id
            view?.findViewById<TextView>(R.id.transaction_date)?.text = transaction.transactionDate
            view?.findViewById<TextView>(R.id.summary)?.text = transaction.summary
            view?.findViewById<TextView>(R.id.credit)?.text = getString(R.string.credit_label)+ " = "+ String.valueOf(transaction.credit)
            view?.findViewById<TextView>(R.id.debit)?.text = getString(R.string.debit_label) + " = "+ String.valueOf(transaction.debit)
            view?.findViewById<TextView>(R.id.gst)?.text = getString(R.string.gst_label) + " = " + String.valueOf(transaction.gst)
        }
    }
}