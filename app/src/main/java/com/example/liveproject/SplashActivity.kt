package com.example.liveproject

import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

@RequiresApi(Build.VERSION_CODES.N_MR1)
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_splash)
        setupShortcuts()
    }


    private fun setupShortcuts() {

            val sManage =   getSystemService(ShortcutManager::class.java)
            val shortcutsList = mutableListOf<ShortcutInfo>()

            shortcutsList.add(ShortcutInfo.Builder(this,"1")
                .setShortLabel("Google ")
                .setLongLabel("Open Google")
                .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))).build())

        shortcutsList.add(ShortcutInfo.Builder(this,"2")
            .setShortLabel("Yahoo Search ")
            .setLongLabel("Open Yahoo Search")
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://in.search.yahoo.com/"))).build())

        shortcutsList.add(ShortcutInfo.Builder(this,"3")
            .setShortLabel("GMail ")
            .setLongLabel("Open GMail")
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gmail.com"))).build())

        shortcutsList.add(ShortcutInfo.Builder(this,"4")
            .setShortLabel("Youtube ")
            .setLongLabel("Open Youtube")
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"))).build())
        shortcutsList.add(ShortcutInfo.Builder(this,"5")
            .setShortLabel("Outlook ")
            .setLongLabel("Open Outlook Mail")
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.outlook.com"))).build())
        shortcutsList.add(ShortcutInfo.Builder(this,"6")
            .setShortLabel("Open Dialer ")
            .setLongLabel("Open Dialer  ")
            .setIntent(Intent(Intent.ACTION_DIAL, Uri.parse("tel://123457890"))).build())


        sManage.addDynamicShortcuts(shortcutsList)
        //sManage.pushDynamicShortcut(shortcutsList)


    }
}