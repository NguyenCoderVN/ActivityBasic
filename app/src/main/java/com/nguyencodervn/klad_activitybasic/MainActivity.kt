package com.nguyencodervn.klad_activitybasic

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var mainToABt: Button
    private lateinit var countBt: Button
    private lateinit var finishBt: Button
    private lateinit var countTv: TextView
    private lateinit var mainTv: TextView
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initId()
        setupEven()
    }

    @SuppressLint("SetTextI18n")
    private fun initId() {
        mainToABt = findViewById(R.id.mainToABt)
        countBt = findViewById(R.id.countBt)
        finishBt = findViewById(R.id.finishBt)
        countTv = findViewById(R.id.countTv)
        mainTv = findViewById(R.id.mainTv)
        countTv.text = "0"
        val api = Build.VERSION.SDK_INT
        mainTv.text = "MainActivity run API $api"
    }

    private fun setupEven() {
        mainToABt.setOnClickListener {
            val intent = Intent(this, ActivityA::class.java)
            startActivity(intent)
        }

        finishBt.setOnClickListener {
            finish()
        }

        countBt.setOnClickListener {
            count += 1
            countTv.text = count.toString()
        }
    }
}