package com.buranchikov.sevenwindsstudiotest.api

import com.buranchikov.sevenwindsstudiotest.data_classes.AuthRequest
import com.buranchikov.sevenwindsstudiotest.data_classes.AuthTokenResponse
import com.buranchikov.sevenwindsstudiotest.data_classes.Product
import com.buranchikov.sevenwindsstudiotest.data_classes.Location
import com.buranchikov.sevenwindsstudiotest.data_classes.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface AppAPI {
    @POST("/auth/login")
    suspend fun auth(@Body authRequest: AuthRequest): AuthTokenResponse

    @Headers(
        "accept: application/json",
        "Content-Type: application/json"
    )
    @POST("/auth/register")
    suspend fun register(
        @Body registerRequest: RegisterRequest,
    ): AuthTokenResponse


//    @Headers("Content-Type: application/json")
    @GET("/location/{id}/menu")
    suspend fun getCoffeeMenu(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): List<Product>

    //APP_API.getCoffeeMenu("Bearer $token", 1) через Bearer

    @GET("/locations")
    suspend fun getLocation(
        @Header("Authorization") token: String
    ): List<Location>
}