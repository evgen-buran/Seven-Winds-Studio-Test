package com.buranchikov.sevenwindsstudiotest.fragments.list_locations

import APP_ACTIVITY
import APP_API
import TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buranchikov.sevenwindsstudiotest.R
import com.buranchikov.sevenwindsstudiotest.data_classes.Location
import com.buranchikov.sevenwindsstudiotest.data_classes.Point
import com.buranchikov.sevenwindsstudiotest.databinding.FragmentCoffeeListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class LocationListFragment : Fragment() {
    private lateinit var binding: FragmentCoffeeListBinding
    private lateinit var adapter: CoffeeListAdapter
    private lateinit var listLocation: List<Location>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoffeeListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.binding.materialToolbar.title = getString(R.string.near_coffee)
        initRecyclerView()
        binding.btnOnMap.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_locationListFragment_to_mapFragment)
        }

        APP_ACTIVITY.viewModel.token.observe(APP_ACTIVITY) {
            getListCoffee("Bearer $it")

        }
    }

    private fun getListCoffee(token: String) {
        CoroutineScope(Dispatchers.IO).launch {
            listLocation = APP_API.getLocation(token)
            MainScope().launch {
                adapter.submitList(listLocation)
                APP_ACTIVITY.viewModel.location.postValue(listLocation)
                Log.d(TAG, "getListCoffee: $listLocation")
                Log.d(TAG, "getListCoffee: ${listLocation[0].point.latitude}")
            }
        }
    }

    private fun getPoints(list: List<Location>): List<Point> {
        return list.map { it.point }
    }

    private fun initRecyclerView() {
        adapter = CoffeeListAdapter()
        binding.rvListCoffee.adapter = adapter
    }
}