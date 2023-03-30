package com.example.appacctiondemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val OPEN_APP_FEATURE = "feature"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val messageView = findViewById<TextView>(R.id.message)
        messageView.text = intent.extras?.getString(OPEN_APP_FEATURE)?:"NA"
    }
}