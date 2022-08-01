package com.karthik.daggersample.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.karthik.daggersample.data.AppSharedPreference
import com.karthik.daggersample.data.PreferencesRepository

class LoginViewModel(
    private val preferences: PreferencesRepository
) : ViewModel() {





    class LoginViewModel constructor(private val context:Context):ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            if(modelClass.isAssignableFrom(LoginViewModel::class.java)){
                val preferences = AppSharedPreference(context)
                val repo = PreferencesRepository(preferences)
                return  LoginViewModel(repo) as T
            }

            throw IllegalArgumentException("Unknown ViewModel class")
        }

    }
}