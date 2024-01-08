package com.buranchikov.sevenwindsstudiotest

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.buranchikov.sevenwindsstudiotest.data_classes.Point
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import com.buranchikov.sevenwindsstudiotest.utils.Point as Point1

class LocationHelper(private val context: Context) {

    fun getCurrentLocation(): Point {
//        var currentLocation: Point = Point(0.0,0.0)
//        if (ContextCompat.checkSelfPermission(
//                context,
//                android.Manifest.permission.ACCESS_FINE_LOCATION
//            ) == PackageManager.PERMISSION_GRANTED
//        ) {
//            val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
//
//            // Проверка доступности провайдера GPS
//            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//                // Запрос на обновление местоположения
//                locationManager.requestLocationUpdates(
//                    LocationManager.GPS_PROVIDER,
//                    0L,
//                    0f,
//                    object : LocationListener {
//                        override fun onLocationChanged(location: Location) {
//                            // В этом месте, location содержит актуальное местоположение
//
//                            currentLocation = Point(location.latitude, location.longitude)
//                            // TODO: Делайте что-то с текущим местоположением
//                        }
//
//                        override fun onProviderDisabled(provider: String) {
//                            // Обработка отключения провайдера
//                        }
//
//                        override fun onProviderEnabled(provider: String) {
//                            // Обработка включения провайдера
//                        }
//
//                        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {
//                            // Обработка изменения статуса провайдера
//                        }
//
//                    }
//                )
//
//                // Возвращаем дефолтное значение (заглушка, так как местоположение еще не получено)
//                return Point(44.7534, 44.9853)
//            } else {
//                // Показывайте пользователю сообщение о том, что GPS выключен
//                // TODO: Добавьте логику для предупреждения пользователя о необходимости включения GPS
//            }
//        } else {
//            throw SecurityException("Permission not granted for accessing location")
//        }
//        return currentLocation

        return Point(44.7534, 44.9853)
    }


    fun haversineDistance(
        point1: Point,
        point2: Point
    ): Double {
        val R = 6371.0 // Радиус Земли в километрах

        val dLat = Math.toRadians(point2.latitude - point1.latitude)
        val dLon = Math.toRadians(point2.longitude - point1.longitude)

        val a = sin(dLat / 2) * sin(dLat / 2) +
                cos(Math.toRadians(point1.latitude)) * cos(Math.toRadians(point2.latitude)) *
                sin(dLon / 2) * sin(dLon / 2)

        val c = 2 * atan2(sqrt(a), sqrt(1 - a))

        return R * c
    }
}
