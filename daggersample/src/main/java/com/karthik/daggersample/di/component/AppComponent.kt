package com.karthik.daggersample.di.component

import com.karthik.daggersample.SampleApplication
import com.karthik.daggersample.di.module.ActivityModule
import com.karthik.daggersample.di.module.ApplicationModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        //ActivityModule::class
    ]
)
interface AppComponent {

    fun inject(application: SampleApplication)

}