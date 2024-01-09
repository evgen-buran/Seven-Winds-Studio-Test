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
import com.buranchikov.sevenwindsstudiotest.LocationHelper
import com.buranchikov.sevenwindsstudiotest.R
import com.buranchikov.sevenwindsstudiotest.data_classes.Product
import com.buranchikov.sevenwindsstudiotest.data_classes.Location
import com.buranchikov.sevenwindsstudiotest.data_classes.Point
import com.buranchikov.sevenwindsstudiotest.databinding.FragmentCoffeeListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class LocationListFragment : Fragment() {
    private lateinit var binding: FragmentCoffeeListBinding
    private lateinit var adapter: LocationListAdapter
    private lateinit var listLocation: List<Location>
    private lateinit var listCoffeeMenu: List<Product>
    private val locationHelper = LocationHelper(APP_ACTIVITY)
    private lateinit var currentPoint: Point
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
            setTokenFromLiveData(it)
            getListCoffee("Bearer $it")
        }
        currentPoint = locationHelper.getCurrentLocation()

        binding.btnX.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                listCoffeeMenu = APP_API.getCoffeeMenu("Bearer $token", 1)
                MainScope().launch {
//                    APP_ACTIVITY.viewModel.menu.postValue(listCoffeeMenu)
                    Log.d(TAG, "onStart: $listCoffeeMenu")
                }

            }
        }
    }

    private fun getListCoffee(token: String) {
        CoroutineScope(Dispatchers.IO).launch {
            listLocation = APP_API.getLocation(token)
            listLocation.forEach {
                it.distance = locationHelper.haversineDistance(currentPoint, it.point)
            }
            MainScope().launch {

                adapter.submitList(listLocation)
                APP_ACTIVITY.viewModel.location.postValue(listLocation)
            }
        }
    }


    private fun getPoints(list: List<Location>): List<Point> {
        return list.map { it.point }
    }

    private fun initRecyclerView() {
        adapter = LocationListAdapter()
        binding.rvListCoffee.adapter = adapter
    }

    companion object {
        lateinit var token: String
        fun setTokenFromLiveData(token: String) {
            this.token = token
        }

        fun click(id:Int) {
            CoroutineScope(Dispatchers.IO).launch {
                val listMenu = APP_API.getCoffeeMenu("Bearer $token", id)
                MainScope().launch {
                    Log.d(TAG, "click: $listMenu")
                    APP_ACTIVITY.viewModel.menu.postValue(listMenu)
                    APP_ACTIVITY.navController.navigate(R.id.action_сoffeeListFragment_to_menuFragment)
                }

            }
        }
    }
}