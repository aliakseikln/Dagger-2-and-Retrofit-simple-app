package com.example.dagger2demokotlin

import android.app.Application
import com.example.dagger2demokotlin.di.DaggerRetrofitComponent
import com.example.dagger2demokotlin.di.RetrofitModule
import com.example.dagger2demokotlin.di.RetrofitComponent


class MyApplication : Application() {

    private lateinit var retrofitComponent: RetrofitComponent

    override fun onCreate() {
        super.onCreate()

        retrofitComponent = DaggerRetrofitComponent.builder()
            .retroModule(RetrofitModule())
            .build()
    }

    fun getRetrofitComponent(): RetrofitComponent {
        return retrofitComponent
    }
}