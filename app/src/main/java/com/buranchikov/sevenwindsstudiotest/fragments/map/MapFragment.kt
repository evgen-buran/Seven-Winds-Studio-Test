package com.buranchikov.sevenwindsstudiotest.fragments.map

import API_KEY
import APP_ACTIVITY
import TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buranchikov.sevenwindsstudiotest.R
import com.buranchikov.sevenwindsstudiotest.databinding.FragmentMapBinding
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.TextStyle
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

class MapFragment : Fragment() {
    private lateinit var binding: FragmentMapBinding
    private lateinit var map: MapManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        MapKitFactory.setApiKey(API_KEY)
        MapKitFactory.initialize(APP_ACTIVITY)

        binding = FragmentMapBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onStart() {
        super.onStart()
        val imageProvider = ImageProvider.fromResource(
            APP_ACTIVITY,
            R.mipmap.map_pin_round
        )
        APP_ACTIVITY.binding.materialToolbar.title = getString(R.string.map)
        MapKitFactory.getInstance().onStart()
        map = MapManager()
        APP_ACTIVITY.viewModel.location.observe(APP_ACTIVITY) {
            for (location in it) {
                binding.mapView.map.move(
                    CameraPosition(
                        Point(location.point.latitude, location.point.longitude),
                        /* zoom = */ 10.0f,
                        /* azimuth = */ 0.0f,
                        /* tilt = */ 0.0f
                    )
                )
                val placemark = binding.mapView.map.mapObjects.addPlacemark()
                placemark.geometry = Point(location.point.latitude, location.point.longitude)
                placemark.setIcon(imageProvider)
                placemark.setText(location.name)
                placemark.setTextStyle(
                    TextStyle(
                        13.0f,
                        R.color.btn_color_pressed,
                        null,
                        TextStyle.Placement.BOTTOM,
                        0.0f,
                        true,
                        false
                    )
                )
            }
        }
        binding.mapView.onStart()
    }


    override fun onStop() {
        binding.mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()

    }
}


//APP_ACTIVITY.viewModel.points.observe(APP_ACTIVITY) {
//            for (point in it) {
//                Log.d(TAG, "onStart: Ш:point.latitude - Д:point.longitude ")
//                val placemark = binding.mapView.map.mapObjects.addPlacemark().apply {
//                    geometry = Point(44.724525, 44.724525)
//                    setIcon(imageProvider)
//                }
//            }
//            it.forEach {
//                binding.mapView.map.mapObjects.addPlacemark().apply {
//                    geometry = Point(it.latitude, it.longitude)
//                    setIcon(imageProvider)
//                }
//            }
