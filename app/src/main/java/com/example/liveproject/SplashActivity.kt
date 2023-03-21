package com.example.liveproject

import android.content.Intent
import android.content.pm.ShortcutManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

@RequiresApi(Build.VERSION_CODES.N_MR1)
class SplashActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_splash)
        setupShortcuts()
    }


    @RequiresApi(Build.VERSION_CODES.R)
    private fun setupShortcuts() {

            val sManage =   getSystemService(ShortcutManager::class.java)
            val shortcutsList = mutableListOf<ShortcutInfoCompat>()

            shortcutsList.add(ShortcutInfoCompat.Builder(this,"1")
                .setShortLabel("Google ")
                .setLongLabel("Open Google")
                .setRank(1)
                .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))).build())

        shortcutsList.add(ShortcutInfoCompat.Builder(this,"2")
            .setShortLabel("Yahoo Search ")
            .setLongLabel("Open Yahoo Search")
            .setRank(2)
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://in.search.yahoo.com/"))).build())

        shortcutsList.add(ShortcutInfoCompat.Builder(this,"4")
            .setShortLabel("Youtube ")
            .setLongLabel("Open Youtube")
            .setRank(3)
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"))).build())

        shortcutsList.add(ShortcutInfoCompat.Builder(this,"3")
            .setShortLabel("GMail ")
            .setLongLabel("Open GMail")
            .setRank(4)
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gmail.com"))).build())

        shortcutsList.add(ShortcutInfoCompat.Builder(this,"6")
            .setShortLabel("Open Dialer ")
            .setLongLabel("Open Dialer  ")
            .setRank(5)
            .setIntent(Intent(Intent.ACTION_DIAL, Uri.parse("tel://123457890"))).build())
        shortcutsList.add(ShortcutInfoCompat.Builder(this,"5")
            .setShortLabel("Outlook ")
            .setLongLabel("Open Outlook Mail")
            .setRank(6)
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.outlook.com"))).build())
        //sManage.addDynamicShortcuts(shortcutsList)
        //sManage.dynamicShortcuts = shortcutsList

            shortcutsList.forEach { shortcutInfo ->
                ShortcutManagerCompat.pushDynamicShortcut(this@SplashActivity, shortcutInfo)
            }




    }
}