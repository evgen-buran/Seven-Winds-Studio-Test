package com.buranchikov.sevenwindsstudiotest.fragments.order

import APP_ACTIVITY
import TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.buranchikov.sevenwindsstudiotest.R
import com.buranchikov.sevenwindsstudiotest.data_classes.Order
import com.buranchikov.sevenwindsstudiotest.databinding.FragmentOrderListBinding

class OrderListFragment : Fragment() {
    lateinit var binding: FragmentOrderListBinding
    private var listOrder = mutableListOf<Order>()
    lateinit var adapter: OrderAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.binding.materialToolbar.title = getString(R.string.youre_order)
        initRecyclerView()

        APP_ACTIVITY.viewModel.listOrder.observe(APP_ACTIVITY) {
            if (it.isEmpty()) {
                binding.tvAcceptOrder.text = getString(R.string.empty_list_order)
                binding.btnPay.visibility = View.INVISIBLE
            } else {
                binding.btnPay.visibility = View.VISIBLE
            }
            adapter.submitList(it)
        }


        binding.btnPay.setOnClickListener {
            binding.tvAcceptOrder.text = getString(R.string.text_accept_order)
        }
    }


    private fun initRecyclerView() {
        adapter = OrderAdapter()
        binding.rvListOrder.adapter = adapter
    }


}