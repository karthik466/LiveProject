package com.karthik.daggersample.di.module

import androidx.lifecycle.ViewModel
import com.karthik.daggersample.presentation.LoginActivity
import com.karthik.daggersample.presentation.viewmodel.LoginViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


interface AppInjectorComponent {

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
        //ActivityModule::class,
        AndroidInjectionModule::class],
    dependencies = [AppInjectorComponent::class]
)
interface LoginActivityComponent : AndroidInjector<LoginActivity>{
   // fun inject(application: SampleApplication)

    @Component.Builder
    abstract class Builder: AndroidInjector<LoginActivity>{

        abstract fun plus(component: AppInjectorComponent):Builder

        abstract fun plus():LoginActivityComponent

    }


    //fun injectActivity(activity: LoginActivity)
    //fun providePreference(): SharedPreferences

//    @Component.Builder
//    interface Builder  {
//        //abstract fun append(component: AppInjectorModule): Builder
//
//        fun appModule(module: ApplicationModule): Builder
//
//
//        fun build(): LoginActivityComponent
//
//
//    }
//    // fun build():LoginActivityComponent


}


object Navigation {

    fun init(component: AppInjectorComponent) {



    }

}