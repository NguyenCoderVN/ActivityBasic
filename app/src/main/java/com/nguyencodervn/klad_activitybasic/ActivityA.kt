package com.nguyencodervn.klad_activitybasic

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class ActivityA : AppCompatActivity() {
    private lateinit var receivedTv: TextView
    private lateinit var returnBt: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        Timber.i("onCreate")
        receivedTv = findViewById(R.id.receivedTv)
        returnBt = findViewById(R.id.returnBt)
        returnBt.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy")
    }
}