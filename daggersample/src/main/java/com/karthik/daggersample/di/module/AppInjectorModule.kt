package com.karthik.daggersample.di.module

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.karthik.daggersample.SampleApplication
import com.karthik.daggersample.presentation.LoginActivity
import com.karthik.daggersample.presentation.viewmodel.LoginViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


interface AppInjectorModule {

    fun appInject()

}

@Module
interface UIViewModelModule {

    @Binds
    fun bindView(viewModelFactory: LoginViewModel): ViewModel

}

@Module
interface UIViewModelModule1 {


}

@Singleton
@Component(
    modules = [UIViewModelModule::class, UIViewModelModule1::class,
        ApplicationModule::class,
        ActivityModule::class,
        AndroidInjectionModule::class],
)
interface LoginActivityComponent {
    fun inject(application: SampleApplication)
    //fun injectActivity(activity: LoginActivity)
    //fun providePreference(): SharedPreferences

    @Component.Builder
    interface Builder  {
        //abstract fun append(component: AppInjectorModule): Builder

        fun appModule(module: ApplicationModule): Builder


        fun build(): LoginActivityComponent


    }
    // fun build():LoginActivityComponent


}


object Navigation {

    fun init(component: AppInjectorModule) {



    }

}