package com.karthik.daggersample.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.karthik.daggersample.data.PreferencesRepository
import com.karthik.daggersample.data.model.UserDetails
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val preferences: PreferencesRepository
) : ViewModel() {

    private val onReadUserDetails = MutableLiveData<UserDetails>()

    val onUserDetailsReceived :LiveData<UserDetails>
    get() = onReadUserDetails


    init {
        readUserDetails()
    }

    private fun readUserDetails() {
        val user = preferences.readUserDetails()
        onReadUserDetails.postValue(user)

    }

    fun saveUserDetails(userName: String, pwd: String) {
        preferences.saveUserDetails(userName,pwd)
    }


//    class LoginViewModel constructor(private val context:Context):ViewModelProvider.Factory{
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            @Suppress("UNCHECKED_CAST")
//            if(modelClass.isAssignableFrom(LoginViewModel::class.java)){
//                val preferences = AppSharedPreference(context)
//                val repo = PreferencesRepository(preferences)
//                return  LoginViewModel(repo) as T
//            }
//
//            throw IllegalArgumentException("Unknown ViewModel class")
//        }
//
//    }
}