package com.buranchikov.sevenwindsstudiotest.utils

import kotlin.math.*

data class Point(val latitude: Double, val longitude: Double)

fun haversineDistance(point1: Point, point2: Point): Double {
    val R = 6371.0 // Радиус Земли в километрах

    val dLat = Math.toRadians(point2.latitude - point1.latitude)
    val dLon = Math.toRadians(point2.longitude - point1.longitude)

    val a = sin(dLat / 2) * sin(dLat / 2) +
            cos(Math.toRadians(point1.latitude)) * cos(Math.toRadians(point2.latitude)) *
            sin(dLon / 2) * sin(dLon / 2)

    val c = 2 * atan2(sqrt(a), sqrt(1 - a))

    return R * c
}

fun main() {
    // Пример использования
    val point1 = Point(53.349805, -6.26031) // Дублин, Ирландия
    val point2 = Point(51.509865, -0.118092) // Лондон, Великобритания

    val distance = haversineDistance(point1, point2)
    println("Расстояние между точками: $distance км")
}
