package com.karthik.daggersample.data

import android.content.Context
import android.content.Context.MODE_PRIVATE

class AppSharedPreference constructor(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("dagger_sample", MODE_PRIVATE)


    fun storeStringPreference(key:String,value:String?){
        sharedPreferences.edit()
            .putString(key,value)
            .apply()
    }

    fun getStringPreference(key:String, default:String=""): String {
        return sharedPreferences.getString(key,default)?: default
    }
}