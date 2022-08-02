package com.karthik.dagger2demo.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class SharedPrefModule constructor(context: Context) {
    private val context: Context

    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("context", Context.MODE_PRIVATE)
    }

    init {
        this.context = context
    }
}
