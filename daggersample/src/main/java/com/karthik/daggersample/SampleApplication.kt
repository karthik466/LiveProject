package com.karthik.daggersample

import android.app.Application
import com.karthik.daggersample.di.component.DaggerAppComponent
import com.karthik.daggersample.di.module.ApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class SampleApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var mInject: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        createAppComponent()
    }

    private fun createAppComponent() {
        val component = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        component.inject(this)

    }

    override fun androidInjector(): AndroidInjector<Any> {
        return mInject
    }
}