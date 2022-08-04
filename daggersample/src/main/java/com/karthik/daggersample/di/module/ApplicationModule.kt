package com.karthik.daggersample.di.module

import android.content.Context
import com.karthik.daggersample.data.AppSharedPreference
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule constructor(private val context: Context) {

    @Singleton
    @Provides
    fun provideContext():Context{
        return context
    }
    @Singleton
    @Provides
    fun provideApplicationPreference():AppSharedPreference{
        return AppSharedPreference(context)
    }
}