package com.karthik.daggersample.di.module

import com.karthik.daggersample.presentation.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

//@Module
abstract class ActivityModule {

    //@ContributesAndroidInjector
    abstract fun contributesLoginActivityInject(): LoginActivity
}