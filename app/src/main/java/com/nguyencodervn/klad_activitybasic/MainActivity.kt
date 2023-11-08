package com.nguyencodervn.klad_activitybasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var mainToABt : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainToABt = findViewById(R.id.mainToABt)

        mainToABt.setOnClickListener {
            // Tạo câu lệnh chuyển sang Activity A
        }
    }
}