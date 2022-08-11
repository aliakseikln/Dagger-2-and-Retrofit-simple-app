package com.example.dagger2demokotlin.di

import com.example.dagger2demokotlin.model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitServiceInterface {

    @GET("repositories")
    fun getDataFromApi(@Query("q") query: String): Call<RecyclerList>
}