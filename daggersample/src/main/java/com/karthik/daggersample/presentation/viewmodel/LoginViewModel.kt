package com.karthik.daggersample.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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


}