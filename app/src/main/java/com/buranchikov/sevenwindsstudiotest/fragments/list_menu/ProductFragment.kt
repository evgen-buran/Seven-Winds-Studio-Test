package com.buranchikov.sevenwindsstudiotest.fragments.list_menu

import APP_ACTIVITY
import TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import com.buranchikov.sevenwindsstudiotest.R
import com.buranchikov.sevenwindsstudiotest.data_classes.Order
import com.buranchikov.sevenwindsstudiotest.data_classes.Product
import com.buranchikov.sevenwindsstudiotest.databinding.FragmentProductsBinding


class ProductFragment : Fragment() {
    private lateinit var binding: FragmentProductsBinding
    private lateinit var adapter: ProductListAdapter
    private val listOrder = mutableListOf<Order>()
    private var listProducts = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initRecyclerView()
        APP_ACTIVITY.binding.materialToolbar.title = getString(R.string.menu)
        APP_ACTIVITY.viewModel.menu.observe(APP_ACTIVITY) {
            listProducts = it as MutableList<Product>
            adapter.submitList(it)

        }

        binding.btnGotoPay.setOnClickListener {
            getListOrder()

            APP_ACTIVITY.viewModel.listOrder.postValue(listOrder)
            APP_ACTIVITY.navController.navigate(R.id.action_menuFragment_to_orderListFragment)

        }
    }

    private fun initRecyclerView() {
        adapter = ProductListAdapter()
        binding.rvMenu.adapter = adapter
    }

    fun getListOrder() {
        for (i in 0..<adapter.itemCount) {
            val holder =
                binding.rvMenu.findViewHolderForAdapterPosition(i) as? ProductListAdapter.Holder
            val countText = holder?.binding?.tvCountMenuItem?.text.toString()
            val count = countText.toInt()
            if (count > 0) {
                listOrder.add(Order(i, listProducts[i], count))
            }

        }

    }


}