package com.karthik.dagger2demo.di

import com.karthik.dagger2demo.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SharedPrefModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}