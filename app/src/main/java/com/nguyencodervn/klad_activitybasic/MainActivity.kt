package com.nguyencodervn.klad_activitybasic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mainToABt: Button
    private lateinit var countBt: Button
    private lateinit var finishBt: Button
    private lateinit var countTv: TextView
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainToABt = findViewById(R.id.mainToABt)
        countBt = findViewById(R.id.countBt)
        finishBt = findViewById(R.id.finishBt)
        countTv = findViewById(R.id.countTv)
        countTv.text = "0"
        setupEven()
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