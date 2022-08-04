package com.karthik.daggersample

import android.app.Application
import android.util.Log
import com.karthik.daggersample.di.component.DaggerAppComponent
import com.karthik.daggersample.di.module.AppInjectorModule
import com.karthik.daggersample.di.module.ApplicationModule
import com.karthik.daggersample.di.module.DaggerLoginActivityComponent
import com.karthik.daggersample.di.module.Navigation
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
        Navigation.init(object :AppInjectorModule{
            override fun appInject() {
                Log.i("TAG", "Navigation.init")
            }

        })
    }

    private fun createAppComponent() {
        //Way 1: General way to add component
        val appComponent = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        appComponent.inject(this)


//        //Way 2: Using Component Build
//        val component = DaggerLoginActivityComponent.builder()
//            .appModule(ApplicationModule(this))
//            .build()
//        component.inject(this)

    }

    override fun androidInjector(): AndroidInjector<Any> {
        return mInject
    }
}