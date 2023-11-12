package com.nguyencodervn.klad_activitybasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
    }
}