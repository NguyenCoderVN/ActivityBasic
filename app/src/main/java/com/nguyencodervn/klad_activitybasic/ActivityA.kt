package com.nguyencodervn.klad_activitybasic

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ActivityA : AppCompatActivity() {
    private lateinit var receivedTv: TextView
    private lateinit var returnBt: Button
    private var count: Int = 0
    private lateinit var activity: String
    private var transfer01: Transfer01? = null
    private var transfer02: Transfer02? = null

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