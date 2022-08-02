package com.karthik.daggersample.di.module

import com.karthik.daggersample.presentation.LoginActivity
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector

@Module
abstract class AppInjectorModule : AndroidInjector<LoginActivity> {



}