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

        receivedTv = findViewById(R.id.receivedTv)
        returnBt = findViewById(R.id.returnBt)

        returnBt.setOnClickListener {
            finish()
        }
    }
}