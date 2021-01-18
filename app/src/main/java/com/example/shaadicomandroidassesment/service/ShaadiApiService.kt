package com.example.shaadicomandroidassesment.service

import com.example.shaadicomandroidassesment.data.ShaadiResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ShaadiApiService {

    @GET("/api")
    fun getShaadiResponse(@Query("result") limit: String="10") : Deferred<ShaadiResponse>
}