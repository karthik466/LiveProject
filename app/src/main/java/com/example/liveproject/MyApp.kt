package com.example.liveproject

import android.app.Application

class MyApp :Application() {

    override fun onCreate() {
        try{
            Thread.sleep(5000)
        }catch (e:Exception){

        }
        super.onCreate()
    }

}