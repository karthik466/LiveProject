package com.karthik.daggersample

import android.app.Application
import com.karthik.daggersample.di.component.DaggerAppComponent

class SampleApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        createAppComponent()
    }

    private fun createAppComponent() {
        val component = DaggerAppComponent.create()

    }
}