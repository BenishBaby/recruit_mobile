package com.asb.mobiletest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.findViewById<Button>(R.id.button_second).setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("requestKey") { requestKey, bundle ->
            val result = bundle.getParcelable<Transaction>("bundleKey")
            displayDetails(result)
        }
    }

    private fun displayDetails(transaction: Transaction?) {
        transaction?.let {
            view?.findViewById<TextView>(R.id.transaction_id)?.text = transaction.id
            view?.findViewById<TextView>(R.id.transaction_date)?.text = transaction.transactionDate
            view?.findViewById<TextView>(R.id.summary)?.text = transaction.summary
            view?.findViewById<TextView>(R.id.credit)?.text = String.valueOf(transaction.credit)
            view?.findViewById<TextView>(R.id.debit)?.text = String.valueOf(transaction.debit)
        }
    }
}