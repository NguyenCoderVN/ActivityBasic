package com.nguyencodervn.klad_activitybasic

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var mainToABt : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainToABt = findViewById(R.id.mainToABt)

        mainToABt.setOnClickListener {
            // Tạo câu lệnh chuyển sang Activity A
            val intent = Intent(this, ActivityA::class.java)
            startActivity(intent)
        }
        // Tìm hiểu về Logcat trong Android
        Log.i(TAG, "Welcome to Android Kotlin")
        Timber.i("Welcome to Android by Timber");
    }
    companion object {
        const val TAG = "MainActivity"
    }
}