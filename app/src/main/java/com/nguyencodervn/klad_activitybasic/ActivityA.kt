package com.nguyencodervn.klad_activitybasic

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nguyencodervn.klad_activitybasic.MainActivity.Companion.KEY_ACTIVITY
import com.nguyencodervn.klad_activitybasic.MainActivity.Companion.KEY_COUNT

class ActivityA : AppCompatActivity() {
    private lateinit var receivedTv: TextView
    private lateinit var returnBt: Button
    private var count: Int = 0
    private lateinit var activity: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        receivedTv = findViewById(R.id.receivedTv)
        returnBt = findViewById(R.id.returnBt)

        returnBt.setOnClickListener {
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        activity = intent.getStringExtra(KEY_ACTIVITY)!!
        count = intent.getIntExtra(KEY_COUNT, 0)
        receivedTv.text = "$activity $count"
    }
}