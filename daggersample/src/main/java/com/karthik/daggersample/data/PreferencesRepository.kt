package com.karthik.daggersample.data

import com.karthik.daggersample.data.model.UserDetails

class PreferencesRepository constructor(
    private val appPreference: AppSharedPreference
) {

    fun saveUserDetails(userName: String, password: String) {

        appPreference.storeStringPreference(USER_NAME, userName)
        appPreference.storeStringPreference(USER_PASSWORD, password)
    }


    fun readUserDetails(): UserDetails {
        return UserDetails(
            appPreference.getStringPreference(USER_NAME, ""),
            appPreference.getStringPreference(USER_PASSWORD, "")
        )
    }

    companion object {
        private const val USER_NAME = "user.name"
        private const val USER_PASSWORD = "user.password"
    }
}