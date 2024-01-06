package com.buranchikov.sevenwindsstudiotest.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AppAPI {
    @POST("auth/login")
    suspend fun auth(@Body authRequest: AuthRequest): Response<User>
}