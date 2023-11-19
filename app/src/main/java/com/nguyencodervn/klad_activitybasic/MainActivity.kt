package com.nguyencodervn.klad_activitybasic

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var countBt: Button
    private lateinit var sendBt: Button

    private lateinit var mainTv: TextView
    private lateinit var countTv: TextView
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initId()
        setupEven()
    }

    private fun setupEven() {

        sendBt.setOnClickListener {
            val intent = Intent(this, ActivityA::class.java)
            startActivity(intent)
        }

        countBt.setOnClickListener {
            count += 1
            countTv.text = count.toString()
        }
    }

    companion object {
        const val KEY_KIND = "KEY_KIND"
        const val KEY_ACTIVITY = "KEY_ACTIVITY"
        const val KEY_COUNT = "KEY_COUNT"
        const val KEY_OBJECT = "KEY_OBJECT"
    }

    @SuppressLint("SetTextI18n")
    private fun initId() {
        sendBt = findViewById(R.id.sendNormalBt)
        sendBt = findViewById(R.id.sendObj01Bt)
        sendBt = findViewById(R.id.sendObj02Bt)
        sendBt = findViewById(R.id.sendBundleBt)
        countBt = findViewById(R.id.countBt)

        mainTv = findViewById(R.id.mainTv)
        countTv = findViewById(R.id.countTv)

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