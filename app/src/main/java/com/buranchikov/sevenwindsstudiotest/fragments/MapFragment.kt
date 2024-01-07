package com.buranchikov.sevenwindsstudiotest.fragments

import API_KEY
import APP_ACTIVITY
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buranchikov.sevenwindsstudiotest.R
import com.buranchikov.sevenwindsstudiotest.databinding.FragmentMapBinding
//import com.yandex.mapkit.MapKitFactory


class MapFragment : Fragment() {
private lateinit var binding:FragmentMapBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
//        MapKitFactory.setApiKey(API_KEY)
//        MapKitFactory.initialize(APP_ACTIVITY)
//        binding.mapView
        return binding.root

    }


    override fun onStart() {
        super.onStart()
//        MapKitFactory.getInstance().onStart()
//        binding.mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
//        MapKitFactory.getInstance().onStop()
//        binding.mapView.onStop()
    }


}