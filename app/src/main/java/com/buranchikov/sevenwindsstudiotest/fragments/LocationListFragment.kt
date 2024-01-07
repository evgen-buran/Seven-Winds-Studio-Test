package com.buranchikov.sevenwindsstudiotest.fragments

import APP_ACTIVITY
import APP_API
import TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buranchikov.sevenwindsstudiotest.databinding.FragmentCoffeeListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import com.buranchikov.sevenwindsstudiotest.data_classes.Points


class LocationListFragment : Fragment() {
    private lateinit var binding: FragmentCoffeeListBinding
    private lateinit var adapter: CoffeeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoffeeListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        initRecyclerView()

        APP_ACTIVITY.viewModel.token.observe(APP_ACTIVITY) {
            getListCoffee("Bearer $it")
        }
    }

    private fun getListCoffee(token: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val list = APP_API.getLocation(token)
            MainScope().launch {
                adapter.submitList(list)
                Log.d(TAG, "getListCoffee: $list")
                Log.d(TAG, "getListCoffee: ${list[0].point.latitude}")
            }
        }
    }

    private fun initRecyclerView() {
        adapter = CoffeeListAdapter()
        binding.rvListCoffee.adapter = adapter
    }
}