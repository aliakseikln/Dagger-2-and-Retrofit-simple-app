package com.example.dagger2demokotlin.di

import com.example.dagger2demokotlin.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
interface RetrofitComponent {

    fun inject(mainActivityViewModel: MainActivityViewModel)
}