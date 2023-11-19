package com.nguyencodervn.klad_activitybasic

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mainToABt: Button
    private lateinit var countBt: Button
    private lateinit var countTv: TextView
    private lateinit var mainTv: TextView
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initId()
        setupEven()
    }

    private fun setupEven() {
        mainToABt.setOnClickListener {
            val intent = Intent(this, ActivityA::class.java)
            startActivity(intent)
        }

        countBt.setOnClickListener {
            count += 1
            countTv.text = count.toString()
        }
    }

    companion object {
        const val KEY_COUNT = "KEY_COUNT"
    }

    @SuppressLint("SetTextI18n")
    private fun initId() {
        mainToABt = findViewById(R.id.mainToABt)
        countBt = findViewById(R.id.countBt)
        countTv = findViewById(R.id.countTv)
        mainTv = findViewById(R.id.mainTv)
        countTv.text = "0"
        val api = Build.VERSION.SDK_INT
        mainTv.text = "MainActivity run API $api"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_COUNT, count)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(KEY_COUNT)
        countTv.text = count.toString()
    }
}