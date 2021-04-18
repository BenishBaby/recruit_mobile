package com.asb.mobiletest.ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asb.mobiletest.R
import com.asb.mobiletest.ui.adapter.ClickCallBack
import com.asb.mobiletest.ui.adapter.TransactionsAdapter
import com.asb.mobiletest.viewmodel.TransactionViewModel
import com.asb.mobiletest.viewmodel.TransactionViewModelFactory
import com.asb.network.model.Transaction
import com.asb.network.repository.TransactionRepositoryImpl

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TransactionsFragment : Fragment(), ClickCallBack {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mProgressBar: ProgressBar


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trasactions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecyclerView = view.findViewById(R.id.recyclerview_transactions)
        mProgressBar = view.findViewById(R.id.progress_bar)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProvider(this, TransactionViewModelFactory(
            TransactionRepositoryImpl()
        )).get(TransactionViewModel::class.java)
        viewModel.getTransactions().observe(viewLifecycleOwner,
            Observer<List<Transaction>> { transactionList ->
                if (transactionList != null && transactionList.isNotEmpty()) {
                    mProgressBar.visibility = View.GONE
                    mRecyclerView.adapter = context?.let { TransactionsAdapter(it, transactionList, this) }
                    val layoutManager = LinearLayoutManager(context)
                    mRecyclerView.layoutManager = layoutManager
                    mRecyclerView.setHasFixedSize(true)
                } else {
                    showErrorMessage()
                }
            })
    }

    private fun showErrorMessage() {
        Toast.makeText(context,
                getString(R.string.transaction_error), Toast.LENGTH_SHORT).show()
    }

    override fun onListItemSelected(transaction: Transaction) {
       findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        setFragmentResult("requestKey", bundleOf("transaction" to transaction))
    }
}